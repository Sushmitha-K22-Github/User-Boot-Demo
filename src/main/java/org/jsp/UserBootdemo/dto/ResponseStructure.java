package org.jsp.UserBootdemo.dto;

public class ResponseStructure<T> {
private String message;
private T body;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public T getBody() {
	return body;
}
public void setBody(T body) {
	this.body = body;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
private int code;

}
