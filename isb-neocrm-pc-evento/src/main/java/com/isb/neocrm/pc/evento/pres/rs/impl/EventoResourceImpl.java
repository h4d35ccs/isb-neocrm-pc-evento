/**
 * 
 */
package com.isb.neocrm.pc.evento.pres.rs.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isb.neocrm.pc.evento.logic.domain.Evento;
import com.isb.neocrm.pc.evento.logic.service.EventoService;
import com.isb.neocrm.pc.evento.pres.rs.EventoResource;
import com.isb.neocrm.pc.evento.pres.rs.api.Response;
import com.isb.neocrm.pc.evento.pres.rs.api.ResponseFactory;

/**
 * @author ottoabreu
 *
 */
@Component
public class EventoResourceImpl implements EventoResource {

	@Autowired
	private EventoService eventservice;
	@Autowired
	private ResponseFactory responseFactory;
	
	private final static Logger log = LoggerFactory
			.getLogger(EventoResourceImpl.class);
	
	
	/* (non-Javadoc)
	 * @see com.isb.neocrm.pc.evento.pres.rs.EventoResource#getEvent(java.lang.String, java.lang.String)
	 */
	@Override
	public Response getEvent(String personType, String personCode) {
		
		log.info("Event  receive: personType: [" + personType+"] personCode: ["+personCode+"]");
		Response response = this.getEventFromService(personType,personCode);
		log.info("Event  response: " + response);
		return response;
	}
	
	
	private Response getEventFromService(String personType,String personCode) {
		Response response = null;
		try {
			Collection<Evento> events = eventservice.getEventoById(personType,personCode);
			response = responseFactory.instanciateEventoResponse(events);
		} catch (Exception e) {
			log.error(
					"An Error occurs while getting the events from the service layer",
					e);
			response = responseFactory.instanciateErrorResponse(e);
		}
		return response;
	}

}
