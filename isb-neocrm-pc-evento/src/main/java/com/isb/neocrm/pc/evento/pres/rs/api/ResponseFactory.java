package com.isb.neocrm.pc.evento.pres.rs.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.isb.neocrm.pc.evento.logic.domain.Evento;
import com.isb.neocrm.pc.evento.pres.rs.api.responsecode.ErrorCode;
import com.isb.neocrm.pc.evento.pres.rs.api.responsecode.ResponseCodeFactory;
import com.isb.neocrm.pc.evento.util.Util;

/**
 * Class that instanciate the differents types of responses
 * 
 * @author ottoabreu
 * 
 */
@Component
public class ResponseFactory {
	
	
	@Value("${app.noevents.msg}")
	private String noEventsMsg;
	
	@Autowired
	private Util util;


	public Response instanciateEventoResponse(Collection<Evento> events) {
		EventoResponse response = new EventoResponse();
		EventoResponseWrapper responseWrapper = new EventoResponseWrapper();
		response.setItem(events);
		String dateFormated = util.getDefaultDateFormatNow();
		response.setSysDate(dateFormated);
		if (events.isEmpty()) {
			response.setEmptyList(noEventsMsg);
		}
		responseWrapper.addEventObject(response);
		return responseWrapper;
	}

	public Response instanciateErrorResponse(Throwable error) {
		ErrorResponse response = new ErrorResponse();
		response.setApplicationMessage(error.getLocalizedMessage());
		ErrorCode errorCode = ResponseCodeFactory.generateErrorCode(error);
		response.setErrorCode(errorCode.getErrorCode());
		response.setConsumerMessage(errorCode.getErrorDescription());
		return response;
	}

	
}
