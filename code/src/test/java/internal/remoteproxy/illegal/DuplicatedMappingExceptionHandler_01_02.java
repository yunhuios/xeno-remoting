package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;

public class DuplicatedMappingExceptionHandler_01_02 {

	@ExceptionHandler
	public void e_01_02_a(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public void e_01_02_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
