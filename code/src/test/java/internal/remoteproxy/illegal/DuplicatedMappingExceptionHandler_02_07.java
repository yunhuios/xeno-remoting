package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_02_07 extends DuplicatedMappingExceptionHandler_02_06 {

	@ExceptionHandler
	public static void e_02_06_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
