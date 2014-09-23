/**
 * 
 */
package com.isb.neocrm.pc.evento.pres.rs.api.responsecode;

/**
 * Enum that define the error codes in the rest layer
 * All the errors will start from 300 to 399
 * @author ottoabreu
 *
 */
public enum RestErrorCode implements ErrorCode{

	GENERAL_ERROR(300,"An error in the REST service prevented to continue with the operation ");
	
	
	private Integer code;
	private String description;
	
	
	private RestErrorCode(int code, String description){
		this.code = code;
		this.description = description;
	}

	@Override
	public int getErrorCode() {
		// TODO Auto-generated method stub
		return this.code;
	}

	@Override
	public String getErrorDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}
	
	@Override
	public boolean equals(ErrorCode other) {

		if (other.getErrorDescription().equals(this.description)
				&& other.getErrorCode() == this.code) {
			return true;
		} else {
			return false;
		}
	}

	
}
