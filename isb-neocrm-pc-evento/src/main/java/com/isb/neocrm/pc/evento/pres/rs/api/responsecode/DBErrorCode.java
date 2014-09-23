package com.isb.neocrm.pc.evento.pres.rs.api.responsecode;

/**
 * Enum that define the error codes in the data layer All the errors will start
 * from 100 to 199
 * 
 * @author ottoabreu
 * 
 */
public enum DBErrorCode implements ErrorCode {

	CONNECTION_ERROR(100, "The database can not be reached"), OPERATION_ERROR(
			101, "An error occurs while performing a operation in the database");

	private Integer code;
	private String description;

	private DBErrorCode(int code, String description) {
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
