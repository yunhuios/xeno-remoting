package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;

public class DuplicatedMappingExceptionHandler_04_02 {

	@ExceptionHandler
	public static void e_04_02_a(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public void e_04_02_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
