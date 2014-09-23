/**
 * 
 */
package test.com.isb.neocrm.pc.evento.util;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.com.isb.neocrm.pc.evento.testhelper.GenericTestClass;

import com.isb.neocrm.pc.evento.util.Util;

/**
 * @author ottoabreu
 *
 */
public class UtilTest extends GenericTestClass {

	
	@Autowired
	private Util util;
	
	private static final String DATE_REGEX = "^20[0-9]{2}-[0-9]{2}-[0-9A-Za-z]*:[0-9]{2}.[0-9]*$";
	/**
	 * Test method for {@link com.isb.neocrm.pc.evento.util.Util#getDefaultDateFormatNow()}.
	 */
	@Test
	public void testGetDefaultDateFormatNow() {
		String date = util.getDefaultDateFormatNow();
		assertTrue(this.validateDateFormat(date));
		
	}

	/**
	 * Test method for {@link com.isb.neocrm.pc.evento.util.Util#getDefaultDateFormat(java.util.Date)}.
	 */
	@Test
	public void testGetDefaultDateFormat() {
		String date = util.getDefaultDateFormat(new Date());
		assertTrue(this.validateDateFormat(date));
	}
	
	private boolean validateDateFormat(String date){
		Pattern patt = Pattern.compile(DATE_REGEX);
		Matcher matcher = patt.matcher(date);
		matcher.find();
		return matcher.matches();
	}

}
