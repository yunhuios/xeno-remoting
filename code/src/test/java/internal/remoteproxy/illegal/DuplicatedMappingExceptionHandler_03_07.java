package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_03_07 extends DuplicatedMappingExceptionHandler_03_06 {

	@ExceptionHandler
	public static void e_03_06_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
