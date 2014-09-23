package com.isb.neocrm.pc.evento.pres.rs;

import com.isb.neocrm.pc.evento.pres.rs.api.Response;

/**
 * Interface del servicio REST asociado al recurso: evento.
 * Author: schamorro
 * Date: 04/09/14.
 */

public interface EventoResource {
	
    public Response getEvent(String personType,String personCode);
}
