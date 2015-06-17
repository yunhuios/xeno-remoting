package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;

public class DuplicatedMappingExceptionHandler_02_02 {

	@ExceptionHandler
	public static void e_02_02_a(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_02_02_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
