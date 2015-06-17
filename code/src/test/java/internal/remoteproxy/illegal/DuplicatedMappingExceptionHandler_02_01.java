package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_02_01 {

	@ExceptionHandler
	public static void e_02_01_a(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_02_01_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
