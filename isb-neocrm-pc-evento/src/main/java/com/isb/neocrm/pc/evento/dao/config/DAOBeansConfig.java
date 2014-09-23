package com.isb.neocrm.pc.evento.dao.config;

import com.isb.neocrm.pc.evento.dao.EventoDAO;
import com.isb.neocrm.pc.evento.dao.jpa.impl.EventoDAOimpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Definición de los Beans utilizados en los DAO's
 * Author: schamorro
 * Date: 02/09/14.
 */
@Configuration
public class DAOBeansConfig {
    @Bean
    public EventoDAO eventoDAO() {
        return new EventoDAOimpl();
    }
}
