/**
 * 
 */
package com.isb.neocrm.pc.evento.pres.rs.api.responsecode;

/**
 * @author ottoabreu
 *
 */
public interface ErrorCode {
	
	public int getErrorCode();
	
	public String getErrorDescription();
	
	public boolean equals(ErrorCode ob);
	
}
