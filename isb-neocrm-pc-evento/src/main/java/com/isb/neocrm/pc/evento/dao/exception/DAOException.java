/**
 * 
 */
package com.isb.neocrm.pc.evento.dao.exception;

/**
 * Exception that wraps other exceptions in the dao layer
 * @author ottoabreu
 *
 */
public class DAOException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
