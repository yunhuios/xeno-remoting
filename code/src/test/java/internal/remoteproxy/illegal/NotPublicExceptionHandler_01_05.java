package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class NotPublicExceptionHandler_01_05 {

	@ExceptionHandler
	static void e_01_05() {
		// Does nothing.
	}
}
