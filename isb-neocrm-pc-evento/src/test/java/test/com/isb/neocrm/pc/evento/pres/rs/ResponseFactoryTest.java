package test.com.isb.neocrm.pc.evento.pres.rs;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.com.isb.neocrm.pc.evento.testhelper.GenericTestClass;

import com.isb.neocrm.pc.evento.logic.domain.Evento;
import com.isb.neocrm.pc.evento.pres.rs.api.ErrorResponse;
import com.isb.neocrm.pc.evento.pres.rs.api.EventoResponseWrapper;
import com.isb.neocrm.pc.evento.pres.rs.api.Response;
import com.isb.neocrm.pc.evento.pres.rs.api.ResponseFactory;

/**
 * The class <code>ResponseFactoryTest</code> contains tests for the class
 * {@link <code>ResponseFactory</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 22/09/14 23:05
 *
 * @author ottoabreu
 *
 * @version $Revision$
 */
public class ResponseFactoryTest extends GenericTestClass {

	
	@Autowired
	private ResponseFactory responseFactory;
	
	@Test
	public void testInstanciateEventoResponse(){
		Response response = responseFactory.instanciateEventoResponse(new ArrayList<Evento>());
		assertTrue(response != null);
		assertTrue(response instanceof EventoResponseWrapper);
	}
	
	@Test
	public void testInstanciateErrorResponse(){
		Response response = responseFactory.instanciateErrorResponse(new Exception());
		assertTrue(response != null);
		assertTrue(response instanceof ErrorResponse);
	}
}

