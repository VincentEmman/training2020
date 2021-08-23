package org.ssglobal.training.codes;

public class WrongMatrixDimensionException extends Exception {

	private String message = "values not enough for 3 x 3";
	
	public WrongMatrixDimensionException() {
		
	}
	
	public WrongMatrixDimensionException(String newMessage) {
		message = newMessage;
	}

	public String getMessage() {
		return message;
	}
	
	public void printStackTrace() {
		System.err.println(message);
	}
}
