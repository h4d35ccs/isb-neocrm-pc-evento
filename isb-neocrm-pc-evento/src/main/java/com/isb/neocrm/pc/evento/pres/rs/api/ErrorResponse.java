package com.isb.neocrm.pc.evento.pres.rs.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Author: schamorro
 * Date: 02/09/14.
 */
@JsonInclude(Include.NON_NULL)
public class ErrorResponse implements Response {
    
	private static final long serialVersionUID = 1L;

	@JsonProperty("codigo_error")
	private int errorCode;
	@JsonProperty("mensaje_consumidor")
    private String consumerMessage;
	@JsonProperty("mensaje_applicacion")
    private String applicationMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getConsumerMessage() {
        return consumerMessage;
    }

    public void setConsumerMessage(String consumerMessage) {
        this.consumerMessage = consumerMessage;
    }

    public String getApplicationMessage() {
        return applicationMessage;
    }

    public void setApplicationMessage(String applicationMessage) {
        this.applicationMessage = applicationMessage;
    }

	@Override
	public String toString() {
		return "ErrorResponse [errorCode=" + errorCode + ", consumerMessage="
				+ consumerMessage + ", applicationMessage="
				+ applicationMessage + "]";
	}
    
    
}
