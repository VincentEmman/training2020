package org.ssglobal.training.codes;

public class BadIndexException extends Exception{

	private String message = "bad index";
	
	public BadIndexException() {
		
	}
	
	public BadIndexException(String newMessage) {
		message = newMessage;
	}

	public String getMessage() {
		return message;
	}
	
	public void printStackTrace() {
		System.err.println(message);
	}
}
