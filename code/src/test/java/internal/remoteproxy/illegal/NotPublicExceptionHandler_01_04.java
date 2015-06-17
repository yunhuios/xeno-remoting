package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class NotPublicExceptionHandler_01_04 {

	@ExceptionHandler
	protected static void e_01_04() {
		// Does nothing.
	}
}
