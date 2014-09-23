package com.isb.neocrm.pc.evento.pres.rs.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Clase que recopila todos los atributos que van a constituir la respuesta
 * (JSON/XML/Atom/etc.) que devuelve el servicio REST. Author: Otto Abreu Date:
 * 21/09/14.
 */

public class EventoResponseWrapper implements Response {

	private static final long serialVersionUID = 8039686696076370531L;

	@JsonProperty("eventos")
	private List<EventoResponse> events;


	public List<EventoResponse> getEvents() {
		return events;
	}


	public void setEvents(List<EventoResponse> events) {
		this.events = events;
	}
	
	public void addEventObject(EventoResponse event){
		if(this.events == null){
			this.events = new ArrayList<EventoResponse>(1);
		}
		this.events.add(event);
	}
	
}
