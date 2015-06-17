package org.showcase.exception;

@SuppressWarnings("serial")
public class MyException extends Exception {

	public MyException() {
		// Does nothing.
	}

	public MyException(String message) {
		super(message);
	}
}
