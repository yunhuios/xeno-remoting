package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;

public class DuplicatedMappingExceptionHandler_03_02 {

	@ExceptionHandler
	public void e_03_02_a(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_03_02_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
