package org.ssglobal.training.codes;

public class LetterSizeException extends Exception{

	private String message = "not an integer, invalid for array size";
	
	public LetterSizeException() {
		
	}
	
	public LetterSizeException(String newMessage) {
		message = newMessage;
	}

	public String getMessage() {
		return message;
	}
	
	public void printStackTrace() {
		System.err.println(message);
	}
}
