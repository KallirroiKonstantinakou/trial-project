package org.netcompany.accounts.account.exceptions;



/*
 * DataNotFoundException
 * 
 * Exception that throws when there are not data
 */
public class DataNotFoundException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}

}
