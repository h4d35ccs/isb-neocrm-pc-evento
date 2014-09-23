package com.isb.neocrm.pc.evento.dao.jpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isb.neocrm.pc.evento.dao.EventoDAO;
import com.isb.neocrm.pc.evento.dao.exception.DAOException;
import com.isb.neocrm.pc.evento.dao.jpa.entity.EventoEntity;

/**
 * Implementación del EventoDAO Author: Otto Abreu Date: 21/09/14.
 */
@Repository("eventoDao")
public class EventoDAOimpl implements EventoDAO {

	private final static Logger log = LoggerFactory
			.getLogger(EventoDAOimpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<EventoEntity> getEvents(String tipoPers, int codpers) {

		return this.getEventsFromDB(tipoPers, codpers);
	}

	@SuppressWarnings("unchecked")
	private List<EventoEntity> getEventsFromDB(String tipoPers, int codpers) {

		List<EventoEntity> resultList = null;
		try {
			log.debug("Executing query to get eventos");
			resultList = entityManager
					.createNamedQuery("findEventByTipoPerAndCodePer")
					.setParameter("tipopers", tipoPers)
					.setParameter("codpers", codpers).getResultList();
		} catch (Exception e) {
			log.error("Can not get the result from DB", e);
			throw new DAOException(e);
		}

		return resultList;

	}

}
