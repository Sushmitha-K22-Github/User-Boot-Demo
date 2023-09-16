package org.jsp.UserBootdemo.exception;

public class IdNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid Id";
	}

}
