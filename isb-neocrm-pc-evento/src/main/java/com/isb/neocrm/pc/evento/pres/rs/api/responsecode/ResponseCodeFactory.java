/**
 * 
 */
package com.isb.neocrm.pc.evento.pres.rs.api.responsecode;

import org.springframework.transaction.CannotCreateTransactionException;

import com.isb.neocrm.pc.evento.dao.exception.DAOException;
import com.isb.neocrm.pc.evento.logic.exceptions.NotValidEventIDException;
import com.isb.neocrm.pc.evento.logic.exceptions.ServiceException;

/**
 * @author ottoabreu
 * 
 */
public class ResponseCodeFactory {

	public static final ErrorCode generateErrorCode(Throwable e) {
		ErrorCode errorCode = null;

		if (e instanceof ServiceException) {

			errorCode = ResponseCodeFactory.getErrorCodeForServiceError(e
					.getCause());

		} else if (e instanceof DAOException) {

			errorCode = ResponseCodeFactory
					.getErrorCodeForDBError(e.getCause());
		} else if (e instanceof NotValidEventIDException) {
			errorCode = ResponseCodeFactory.getErrorCodeForServiceError(e);
		} else {
			errorCode = ResponseCodeFactory.getGeneralErrorCode(e);
		}

		return errorCode;
	}

	private static ErrorCode getErrorCodeForServiceError(Throwable e) {
		ErrorCode errorCode = null;

		if (e instanceof CannotCreateTransactionException) {

			errorCode = DBErrorCode.CONNECTION_ERROR;

		} else if (e instanceof NotValidEventIDException) {

			errorCode = ServiceLayerErrorCode.INVALID_PARAMS_ERROR;

		} else {
			errorCode = ServiceLayerErrorCode.GENERAL_ERROR;
		}
		return errorCode;

	}

	private static ErrorCode getErrorCodeForDBError(Throwable e) {
		ErrorCode errorCode = DBErrorCode.OPERATION_ERROR;

		return errorCode;
	}

	private static ErrorCode getGeneralErrorCode(Throwable e) {
		ErrorCode errorCode = RestErrorCode.GENERAL_ERROR;

		return errorCode;
	}

}
