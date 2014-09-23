package test.com.isb.neocrm.pc.evento.pres;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import test.com.isb.neocrm.pc.evento.testhelper.GenericDBTestClass;

import com.isb.neocrm.pc.evento.pres.rs.EventoResource;
import com.isb.neocrm.pc.evento.pres.rs.api.ErrorResponse;
import com.isb.neocrm.pc.evento.pres.rs.api.EventoResponse;
import com.isb.neocrm.pc.evento.pres.rs.api.EventoResponseWrapper;
import com.isb.neocrm.pc.evento.pres.rs.api.Response;
import com.isb.neocrm.pc.evento.pres.rs.api.responsecode.ServiceLayerErrorCode;

/**
 * The class <code>EventoResourceTest</code> contains tests for the class
 * {@link <code>EventoResourceImpl</code>}
 * 
 * @pattern JUnit Test Case
 * 
 * @generatedBy CodePro at 22/09/14 21:48
 * 
 * @author ottoabreu
 * 
 * @version $Revision$
 */
public class EventoResourceTest extends GenericDBTestClass {

	@Autowired
	private EventoResource eventoResource;

	@Value("${app.noevents.msg}")
	private String noEventsMsg;

	@Test
	public void testGetEvent() {
		Response response = eventoResource.getEvent(TYPE_IN_DATASET_TO_TEST_E,
				"" + CODE_IN_DATASET_TO_TEST_1111);

		EventoResponseWrapper wrapper = this.validateWrapper(response);
		EventoResponse eventResponse = extractEventoResponseFromWrapper(wrapper);
		eventNotEmptyAndMatchesTheExpectedCount(eventResponse);

	}

	private EventoResponseWrapper validateWrapper(Response response) {

		assertTrue(response instanceof EventoResponseWrapper);
		EventoResponseWrapper wrapper = this.extractWrapper(response);
		assertTrue(wraperEventHolderArrayIsNotEmptyAndHasOnlyOneRecord(wrapper));
		return wrapper;
	}

	private EventoResponseWrapper extractWrapper(Response response) {
		return (EventoResponseWrapper) response;
	}

	private boolean wraperEventHolderArrayIsNotEmptyAndHasOnlyOneRecord(
			EventoResponseWrapper wrapper) {
		if (!wrapper.getEvents().isEmpty() && wrapper.getEvents().size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	private EventoResponse extractEventoResponseFromWrapper(
			EventoResponseWrapper wrapper) {
		return wrapper.getEvents().get(0);
	}

	private void eventNotEmptyAndMatchesTheExpectedCount(
			EventoResponse eventResponse) {
		assertTrue(eventResponse.getEmptyList() == null);
		assertTrue(eventResponse.getItem().size() == TOTAL_MATCHING_RECORDS_E1111_IN_DATASET);
	}

	@Test
	public void testGetEventNoRecord() {
		Response response = eventoResource.getEvent(
				TYPE_NOT_IN_DATASET_TO_TEST, "" + CODE_IN_DATASET_TO_TEST_1111);

		EventoResponseWrapper wrapper = this.validateWrapper(response);
		EventoResponse eventResponse = extractEventoResponseFromWrapper(wrapper);
		eventIsEmpty(eventResponse);

	}

	private void eventIsEmpty(EventoResponse eventResponse) {
		assertTrue(eventResponse.getEmptyList().equals(noEventsMsg));
		assertTrue(eventResponse.getItem().isEmpty());
	}

	@Test
	public void testGetEventInvalidParam() {
		Response response = eventoResource.getEvent(TYPE_IN_DATASET_TO_TEST_E,
				INVALID_STRING_CODE);

		assertTrue(response instanceof ErrorResponse);
		ErrorResponse errorResponse = (ErrorResponse) response;
		
		assertEquals(ServiceLayerErrorCode.INVALID_PARAMS_ERROR.getErrorCode(),
				errorResponse.getErrorCode());
		
		assertEquals(
				ServiceLayerErrorCode.INVALID_PARAMS_ERROR
						.getErrorDescription(),
				errorResponse.getConsumerMessage());
	}

}
