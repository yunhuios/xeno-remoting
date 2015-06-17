package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_01_01 {

	@ExceptionHandler
	public void e_01_01_a(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public void e_01_01_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
