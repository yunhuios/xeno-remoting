package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_03_01 {

	@ExceptionHandler
	public void e_03_01_a(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_03_01_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
