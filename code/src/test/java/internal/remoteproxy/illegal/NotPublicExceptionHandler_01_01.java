package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class NotPublicExceptionHandler_01_01 {

	@ExceptionHandler
	protected void e_01_01() {
		// Does nothing.
	}
}
