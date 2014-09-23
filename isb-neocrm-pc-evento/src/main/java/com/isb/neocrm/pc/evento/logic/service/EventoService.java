package com.isb.neocrm.pc.evento.logic.service;

import java.util.Collection;

import com.isb.neocrm.pc.evento.logic.domain.Evento;

/**
 * Servicios aplicacbles a la clase de dominio Evento.
 * Author: schamorro
 * Date: 02/09/14.
 */
public interface EventoService {
	public  Collection<Evento> getEventoById(String personType, String personCode);
}
