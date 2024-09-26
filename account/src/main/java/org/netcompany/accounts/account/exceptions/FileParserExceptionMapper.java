package org.netcompany.accounts.account.exceptions;

import org.netcompany.accounts.account.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


/*
 * FileParserExceptionMapper
 * 
 * Map the fileParserException and return an error message
 * 
 */
@Provider
public class FileParserExceptionMapper  implements ExceptionMapper<FileParserException>{

	@Override
	public Response toResponse(FileParserException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),500);
		return Response.status(Status.INTERNAL_SERVER_ERROR)
			   .entity(errorMessage)
			   .build();
		
	}

}
