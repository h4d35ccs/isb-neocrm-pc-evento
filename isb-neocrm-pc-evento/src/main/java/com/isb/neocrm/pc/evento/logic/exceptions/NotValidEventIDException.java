/**
 * 
 */
package com.isb.neocrm.pc.evento.logic.exceptions;

/**
 * Indicates an non valid format for the event id
 * @author ottoabreu
 *
 */
public class NotValidEventIDException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	/**
	 * NOT_VALID_PARAM = "The given param do not have a valid format: ";
	 */
	public static final String NOT_VALID_PARAM = "The given param do not have a valid format: ";
	/**
	 * NOT_VALID_NULL_PARAM = "One or all params received are null: ";
	 */
	public static final String NOT_VALID_NULL_PARAM = "One or all params received are null: ";
	
	public NotValidEventIDException(String message) {
		super(message);
		
	}

}
