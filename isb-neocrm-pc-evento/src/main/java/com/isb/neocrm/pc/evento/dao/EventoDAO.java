package com.isb.neocrm.pc.evento.dao;

import java.util.List;

import com.isb.neocrm.pc.evento.dao.jpa.entity.EventoEntity;

/**
 * DAO de los Eventos. Author: schamorro Date: 29/08/14.
 */
public interface EventoDAO {

	public List<EventoEntity> getEvents(String tipoPers, int codpers);
}
