package org.showcase.web.service.extra;

import xeno.remoting.bind.ExceptionHandler;

public class OverrideExceptionHandlerService_01 {

	public String t1(IllegalArgumentException ex) {
		return "t1 in OverrideExceptionHandlerService_01";
	}

	@ExceptionHandler
	public String t2(IllegalStateException ex) {
		return "t2 in OverrideExceptionHandlerService_01";
	}

	public String t3(ArithmeticException ex) {
		return "t3 in OverrideExceptionHandlerService_01";
	}

	@ExceptionHandler
	public String t4(ArrayIndexOutOfBoundsException ex) {
		return "t4 in OverrideExceptionHandlerService_01";
	}

	@ExceptionHandler
	public String t5(ClassCastException ex) {
		return "t5 in OverrideExceptionHandlerService_01";
	}

	public static String s1(ClassNotFoundException ex) {
		return "s1 in OverrideExceptionHandlerService_01";
	}

	@ExceptionHandler
	public static String s2(CloneNotSupportedException ex) {
		return "s2 in OverrideExceptionHandlerService_01";
	}

	public static String s3(ArrayStoreException ex) {
		return "s3 in OverrideExceptionHandlerService_01";
	}

	@ExceptionHandler
	public static String s4(IndexOutOfBoundsException ex) {
		return "s4 in OverrideExceptionHandlerService_01";
	}

	@ExceptionHandler
	public static String s5(InterruptedException ex) {
		return "s5 in OverrideExceptionHandlerService_01";
	}
}
