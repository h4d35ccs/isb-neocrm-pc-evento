/**
 * 
 */
package com.isb.neocrm.pc.evento.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Util class
 * @author ottoabreu
 * 
 */
@Component
public class Util {

	@Value("${app.date.format}")
	private String dateFormat;
	@Value("${app.timezone}")
	private String timezone;

	public String getDefaultDateFormatNow() {

		return this.applyFormatToDate(new Date());

	}
	
	public String getDefaultDateFormat(Date date){
		
		return this.applyFormatToDate(date);
	}
	
	private String applyFormatToDate(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		TimeZone tz = TimeZone.getTimeZone(timezone);
		sdf.setTimeZone(tz);
		return sdf.format(date);
	}
}
