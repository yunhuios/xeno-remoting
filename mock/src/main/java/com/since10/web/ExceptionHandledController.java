package com.since10.web;

import java.util.List;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;
import xeno.remoting.web.JsonDeserializationException;
import xeno.remoting.web.JsonSerializationException;

@RemoteProxy
@SuppressWarnings("rawtypes")
public class ExceptionHandledController {

	@ExceptionHandler
	public String handleException(JsonDeserializationException ex) {
		return "json deserialization exception";
	}

	@ExceptionHandler
	public String handleException(JsonSerializationException ex) {
		return "json serialization exception";
	}

	@ExceptionHandler
	public String handleException(ApplicationGenericException ex) {
		return "application generic exception";
	}

	@ExceptionHandler
	public Object handleException(IllegalArgumentException ex) {
		return new Object();
	}

	@ExceptionHandler
	public int handleException(IllegalStateException ex) {
		return 1 / 0;
	}

	@WebMethod
	public void testFailedDeserialization(List a) {
		// Does nothing.
	}

	@WebMethod
	public Object testFailedSerialization() {
		return new Object();
	}

	@WebMethod
	public void testCustomException() {
		throw new ApplicationGenericException("This is the message from the application generic exception");
	}

	@WebMethod
	public void testUnhandlableException1() {
		throw new IllegalArgumentException("illegal argument exception");
	}

	@WebMethod
	public void testUnhandlableException2() {
		throw new IllegalStateException("illegal state exception");
	}
}
