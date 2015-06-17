package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class NotPublicExceptionHandler_01_03 {

	@ExceptionHandler
	private void e_01_03() {
		// Does nothing.
	}
}
