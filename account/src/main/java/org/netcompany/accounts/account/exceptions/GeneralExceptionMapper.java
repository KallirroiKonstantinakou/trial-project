package org.netcompany.accounts.account.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


/*
 * GeneralExceptionMapper
 * 
 * General Exception and return the message of the exception
 * 
 */

@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		String errorMessage = ex.getMessage();
		return Response.status(Status.INTERNAL_SERVER_ERROR)
			   .entity(errorMessage)
			   .build();
		
	}

}
