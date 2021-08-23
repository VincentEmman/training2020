package org.ssglobal.training.codes;

public class ElementDecimalException extends Exception{

	private String message = "element is not an integer";
	
	public ElementDecimalException() {
		
	}
	
	public ElementDecimalException(String newMessage) {
		message = newMessage;
	}

	public String getMessage() {
		return message;
	}
	
	public void printStackTrace() {
		System.err.println(message);
	}
}
