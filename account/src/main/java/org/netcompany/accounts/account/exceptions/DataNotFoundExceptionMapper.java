package org.netcompany.accounts.account.exceptions;

import org.netcompany.accounts.account.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/*
 * 
 * DataNotFoundExceptionMapper
 * 
 * Map the DataNotFoundException and return an error message 
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),404);
		return Response.status(Status.NOT_FOUND)
			   .entity(errorMessage)
			   .build();
		}

}
