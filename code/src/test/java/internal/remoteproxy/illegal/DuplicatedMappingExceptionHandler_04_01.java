package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_04_01 {

	@ExceptionHandler
	public static void e_04_01_a(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public void e_04_01_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
