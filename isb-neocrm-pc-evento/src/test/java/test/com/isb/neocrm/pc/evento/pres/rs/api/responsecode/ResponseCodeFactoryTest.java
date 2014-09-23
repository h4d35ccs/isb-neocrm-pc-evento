package test.com.isb.neocrm.pc.evento.pres.rs.api.responsecode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.transaction.CannotCreateTransactionException;

import com.isb.neocrm.pc.evento.dao.exception.DAOException;
import com.isb.neocrm.pc.evento.logic.exceptions.NotValidEventIDException;
import com.isb.neocrm.pc.evento.logic.exceptions.ServiceException;
import com.isb.neocrm.pc.evento.pres.rs.api.responsecode.DBErrorCode;
import com.isb.neocrm.pc.evento.pres.rs.api.responsecode.ErrorCode;
import com.isb.neocrm.pc.evento.pres.rs.api.responsecode.ResponseCodeFactory;
import com.isb.neocrm.pc.evento.pres.rs.api.responsecode.RestErrorCode;
import com.isb.neocrm.pc.evento.pres.rs.api.responsecode.ServiceLayerErrorCode;

/**
 * The class <code>ResponseCodeFactoryTest</code> contains tests for the class
 * {@link <code>ResponseCodeFactory</code>}
 * 
 * @pattern JUnit Test Case
 * 
 * @generatedBy CodePro at 22/09/14 22:27
 * 
 * @author ottoabreu
 * 
 * @version $Revision$
 */
public class ResponseCodeFactoryTest {

	@Test
	public void testResponseCodeServiceNoConnection() {
		CannotCreateTransactionException innerEx = new CannotCreateTransactionException(
				"Test Ex");
		ErrorCode errorCode = getErrorCodeFromServiceEx(innerEx);

		assertTrue(errorCode.equals(DBErrorCode.CONNECTION_ERROR));
	}

	@Test
	public void testResponseCodeServiceInvalidParam() {
		NotValidEventIDException innerEx = new NotValidEventIDException(
				"Test Ex");
		ErrorCode errorCode = getErrorCodeFromServiceEx(innerEx);
		assertTrue(errorCode.equals(ServiceLayerErrorCode.INVALID_PARAMS_ERROR));
	}

	@Test
	public void testResponseCodeServiceIGeneralError() {
		Exception innerEx = new Exception("Test Ex");
		ErrorCode errorCode = getErrorCodeFromServiceEx(innerEx);
		assertTrue(errorCode.equals(ServiceLayerErrorCode.GENERAL_ERROR));
	}

	private ErrorCode getErrorCodeFromServiceEx(Exception innerEx) {

		ServiceException se = this.instanciateServiceException(innerEx);
		ErrorCode errorCode = ResponseCodeFactory.generateErrorCode(se);
		return errorCode;
	}

	private ServiceException instanciateServiceException(Exception innerEx) {
		ServiceException se = new ServiceException(innerEx);
		return se;
	}
	@Test
	public void testResponseCodeDAOOperantion() {
		Exception innerEx = new Exception("Test Ex");
		ErrorCode errorCode = getErrorCodeFromDAOEx(innerEx);
		assertTrue(errorCode.equals(DBErrorCode.OPERATION_ERROR));
	}
	

	private ErrorCode getErrorCodeFromDAOEx(Exception innerEx) {

		DAOException de = this.instanciateDAOException(innerEx);
		ErrorCode errorCode = ResponseCodeFactory.generateErrorCode(de);
		return errorCode;
	}

	private DAOException instanciateDAOException(Exception innerEx) {
		DAOException e = new DAOException(innerEx);
		return e;
	}
	
	@Test
	public void testResponseCodeGeneralException() {
		
		ErrorCode errorCode = getErrorCodeFromRestEx();
		assertTrue(errorCode.equals(RestErrorCode.GENERAL_ERROR));
	}
	
	private ErrorCode getErrorCodeFromRestEx() {

		Exception e = new Exception("Test Ex");
		ErrorCode errorCode = ResponseCodeFactory.generateErrorCode(e);
		return errorCode;
	}

	

}
