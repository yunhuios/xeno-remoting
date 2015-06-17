package internal.remoteproxy.legal;

import xeno.remoting.bind.ExceptionHandler;

public class OnlyExceptionHandlerExtend_03_04 extends OnlyExceptionHandlerExtend_03_01 {

	@ExceptionHandler
	public static String e_03_04_a(NumberFormatException ex) {
		return null;
	}

	@ExceptionHandler
	public void e_03_04_b(IllegalAccessException ex) {
		// Does nothing.
	}

	public static String e_03_04_c(ClassCastException ex) {
		return null;
	}
}
