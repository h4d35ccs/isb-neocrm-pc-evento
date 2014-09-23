package test.com.isb.neocrm.pc.evento.dao.jpa;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.com.isb.neocrm.pc.evento.testhelper.GenericDBTestClass;

import com.isb.neocrm.pc.evento.dao.EventoDAO;
import com.isb.neocrm.pc.evento.dao.jpa.entity.EventoEntity;

/**
 * The class <code>TestEventoDAOimpl</code> contains tests for the class {@link <code>EventoDAOimpl</code>}
 * 
 * @pattern JUnit Test Case
 * 
 * @generatedBy CodePro at 22/09/14 17:45
 * 
 * @author ottoabreu
 * 
 * @version $Revision$
 */
public class EventoDAOTest extends GenericDBTestClass {

	@Autowired
	private EventoDAO eventoDao;


	@Test
	public void testGetMatchingElements() {
		List<EventoEntity> eventsWithTypeEandCode1111 = eventoDao.getEvents(
				TYPE_IN_DATASET_TO_TEST_E, CODE_IN_DATASET_TO_TEST_1111);
		assertTrue(eventsWithTypeEandCode1111.size() == TOTAL_MATCHING_RECORDS_E1111_IN_DATASET);

	}

	@Test
	public void testGetNotMatchingElements() {
		List<EventoEntity> eventsWithTypeEandCode1111 = eventoDao.getEvents(
				TYPE_NOT_IN_DATASET_TO_TEST, CODE_NOT_IN_DATASET_TO_TEST);
		assertTrue(eventsWithTypeEandCode1111.isEmpty());

	}
}
