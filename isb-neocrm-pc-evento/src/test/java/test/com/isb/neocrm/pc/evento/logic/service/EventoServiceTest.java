package test.com.isb.neocrm.pc.evento.logic.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.com.isb.neocrm.pc.evento.testhelper.GenericDBTestClass;

import com.isb.neocrm.pc.evento.logic.domain.Evento;
import com.isb.neocrm.pc.evento.logic.exceptions.NotValidEventIDException;
import com.isb.neocrm.pc.evento.logic.service.EventoService;

/**
 * The class <code>EventoServiceImplTest</code> contains tests for the class
 * {@link <code>EventoServiceImpl</code>}
 * 
 * @pattern JUnit Test Case
 * 
 * @generatedBy CodePro at 22/09/14 20:59
 * 
 * @author ottoabreu
 * 
 * @version $Revision$
 */
public class EventoServiceTest extends GenericDBTestClass {

	@Autowired
	private EventoService eventService;
	
	@Test
	public void testGetEventoById() {
		Collection<Evento> eventsWithTypePandCode1111 = eventService.getEventoById(
				TYPE_IN_DATASET_TO_TEST_P, "" + CODE_IN_DATASET_TO_TEST_1111);

		assertTrue(eventsWithTypePandCode1111.size() == TOTAL_MATCHING_RECORDS_P1111_IN_DATASET);
	}
	
	@Test
	public void testGetEventoByIdNotMatch() {
		Collection<Evento> eventsWithTypePandCode1111 = eventService.getEventoById(
				TYPE_NOT_IN_DATASET_TO_TEST, "" + CODE_IN_DATASET_TO_TEST_1111);
		assertTrue(eventsWithTypePandCode1111.isEmpty());
	}
	
	@Test(expected =NotValidEventIDException.class)
	public void testGetEventoByIdInvalidCode() {
		 eventService.getEventoById(
				TYPE_NOT_IN_DATASET_TO_TEST,  INVALID_STRING_CODE);
		fail("Should throw an NotValidEventIDException");
	}
	
	@Test(expected =NotValidEventIDException.class)
	public void testGetEventoByIdInvalidType() {
		 eventService.getEventoById(
				 INVALID_STRING_TYPE,  "" + CODE_IN_DATASET_TO_TEST_1111);
		 fail("Should throw an NotValidEventIDException");
	}
	
	@Test(expected =NotValidEventIDException.class)
	public void testGetEventoByIdNullType() {
		 eventService.getEventoById(
				 null,  "" + CODE_IN_DATASET_TO_TEST_1111);
		 fail("Should throw an NotValidEventIDException");
	}
	
	@Test(expected =NotValidEventIDException.class)
	public void testGetEventoByIdNullCode() {
		 eventService.getEventoById(
				 TYPE_NOT_IN_DATASET_TO_TEST,   null);
		 fail("Should throw an NotValidEventIDException");
	}


}
