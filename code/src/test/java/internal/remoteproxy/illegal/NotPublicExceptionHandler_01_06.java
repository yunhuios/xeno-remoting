package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class NotPublicExceptionHandler_01_06 {

	@ExceptionHandler
	private static void e_01_06() {
		// Does nothing.
	}
}