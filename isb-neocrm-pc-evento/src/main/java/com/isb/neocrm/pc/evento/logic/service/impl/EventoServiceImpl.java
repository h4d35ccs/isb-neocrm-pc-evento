package com.isb.neocrm.pc.evento.logic.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.isb.neocrm.pc.evento.dao.EventoDAO;
import com.isb.neocrm.pc.evento.dao.exception.DAOException;
import com.isb.neocrm.pc.evento.dao.jpa.entity.EventoEntity;
import com.isb.neocrm.pc.evento.logic.domain.Evento;
import com.isb.neocrm.pc.evento.logic.exceptions.NotValidEventIDException;
import com.isb.neocrm.pc.evento.logic.exceptions.ServiceException;
import com.isb.neocrm.pc.evento.logic.service.EventoService;
import com.isb.neocrm.pc.evento.util.Util;

/**
 * Implementación del servicio. Author: Otto Abreu Date: 21/09/14.
 */
@Service
public class EventoServiceImpl implements EventoService {

	private final static Logger log = LoggerFactory
			.getLogger(EventoServiceImpl.class);

	@Autowired
	private EventoDAO eventoDao;

	@Autowired
	private Util util;

	@Value("${app.eventid.tp}")
	private String eventIdTipoPerRegex;
	@Value("${app.eventid.cp}")
	private String eventIdCodPerRegex;

	public Collection<Evento> getEventoById(String personType, String personCode) {

		log.info("Received tipoPers: " + personType + " codePers:" + personCode);

		return this.getEvent(personType, personCode);
	}

	public Collection<Evento> getEvent(String personType, String personCode) {

		Collection<Evento> events = null;
		try {

			this.validateInputParams(personType, personCode);
			int codePersInt = Integer.parseInt(personCode);
			log.debug("Calling DAO getEvent with: " + personType + " "
					+ personCode);
			List<EventoEntity> eventsEntities = eventoDao.getEvents(personType,
					codePersInt);

			events = this.transformEntityToDTO(eventsEntities);

		} catch (Exception e) {

			this.handleError(e);
		}

		return events;
	}

	private Collection<Evento> transformEntityToDTO(
			List<EventoEntity> eventsEntities) {

		Collection<Evento> events = CollectionUtils.collect(eventsEntities,
				new Transformer<EventoEntity, Evento>() {

					@Override
					public Evento transform(EventoEntity entity) {
						Evento event = new Evento();
						String iniDateFormated = util
								.getDefaultDateFormat(entity.getFechaini());
						String endDateFormated = util
								.getDefaultDateFormat(entity.getFechafin());
						event.setCodEvento(entity.getCodEvento());
						event.setCodPers(entity.getCodPers());
						event.setDetalle(entity.getDetalle());
						event.setFecha_fin(endDateFormated);
						event.setFecha_ini(iniDateFormated);
						event.setIdEMPR(entity.getIdEMPR());
						event.setIdMostrado(entity.getIdMostrado());
						event.setImagen(entity.getImagen());
						event.setTipoPers(entity.getTipoPers());
						event.setTitulo(entity.getTitulo());

						return event;
					}
				});

		return events;
	}

	private void handleError(Exception e) {

		if (e instanceof DAOException) {
			throw (DAOException) e;
		} else if (e instanceof NotValidEventIDException) {
			throw (NotValidEventIDException) e;
		}
		log.error("Can not get the data because an error: ", e);
		throw new ServiceException(e);
	}

	//
	// private String[] getTipopersAndCodpersFromGivenId(String id) {
	//
	// Matcher matcher = this.getMatcher(eventIdRegex, id);
	// String[] tipoPersAndCodPers = null;
	// if (matcher.find()) {
	//
	// String tipoPer = this.getTipoPers(id);
	// String codePer = this.getCodePers(id);
	// tipoPersAndCodPers = new String[2];
	// tipoPersAndCodPers[TIPO_PERS_INDEX] = tipoPer;
	// tipoPersAndCodPers[CODE_PERS_INDEX] = codePer;
	//
	// } else {
	// throw new NotValidEventIDException(
	// NotValidEventIDException.NOT_VALID_ID + id);
	// }
	//
	// return tipoPersAndCodPers;
	// }
	//
	//
	// private String getTipoPers(String completeID) {
	//
	// return this.getPartOfId(eventIdTipoPerRegex, completeID);
	// }
	//
	// private String getCodePers(String completeID) {
	//
	// return this.getPartOfId(eventIdCodPerRegex, completeID);
	// }
	//

	private void validateInputParams(String personType, String personCode) {
		if (personType != null && personCode != null) {
			this.validatePersonType(personType);
			this.validatePersonCode(personCode);
		} else {
			log.error(NotValidEventIDException.NOT_VALID_NULL_PARAM
					+ personType + " - " + personCode);
			throw new NotValidEventIDException(
					NotValidEventIDException.NOT_VALID_NULL_PARAM + personType
							+ " - " + personCode);
		}
	}

	private void validatePersonType(String personType) {

		this.validateParams(eventIdTipoPerRegex, personType);
	}

	private void validatePersonCode(String personCode) {
		this.validateParams(eventIdCodPerRegex, personCode);
	}

	private void validateParams(String regex, String toValidate) {
		log.debug("Validating with regex:" + regex + " - " + toValidate);
		Matcher matcher = this.getMatcher(regex, toValidate);
		boolean valid = matcher.matches();
		log.debug("is valid? " + valid);
		if (!valid) {
			log.error(NotValidEventIDException.NOT_VALID_PARAM + toValidate);
			throw new NotValidEventIDException(
					NotValidEventIDException.NOT_VALID_PARAM + toValidate);
		}

	}

	private Matcher getMatcher(String regex, String scan) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(scan);
		return matcher;
	}
}
