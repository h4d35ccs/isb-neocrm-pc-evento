/**
 * 
 */
package com.isb.neocrm.pc.evento.logic.exceptions;

/**
 * Exception that wraps other exceptions in the service layer
 * @author ottoabreu
 *
 */
public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
