package org.jsp.UserBootdemo.exception;

public class InvalidCredentialException extends RuntimeException{
	@Override
public String getMessage() {
	return "Invalid credential";
}
}
