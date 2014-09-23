package com.isb.neocrm.pc.evento.pres.rs.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.isb.neocrm.pc.evento.pres.rs.EventoResource;
import com.isb.neocrm.pc.evento.pres.rs.api.Response;

/**
 * Implementación del servicio REST Author: otto abreu Date: 02/09/14.
 */

public class EventoResourceRESTimpl {

	private final static Logger log = LoggerFactory
			.getLogger(EventoResourceRESTimpl.class);

	
	@Autowired
	private EventoResource eventoResource;

	
	@GET
	@Path("/{personType}/{personCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvent(@PathParam("personType") String personType,
			@PathParam("personCode") String personCode) {
		
		log.info("Evento Rest service Invoked");
		Response response = eventoResource.getEvent(personType, personCode);
		log.info("Evento Rest service Ends");
		return response;

	}

}
