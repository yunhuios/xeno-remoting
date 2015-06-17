package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class NotPublicExceptionHandler_01_02 {

	@ExceptionHandler
	void e_01_02() {
		// Does nothing.
	}
}
