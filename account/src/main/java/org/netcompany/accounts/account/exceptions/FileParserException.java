package org.netcompany.accounts.account.exceptions;


/*
 * FileParserException
 * 
 * Exception that throws when something gets wrong with the parsing of the file
 * 
 */
public class FileParserException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public FileParserException(String message) {
		super(message);
	}

}
