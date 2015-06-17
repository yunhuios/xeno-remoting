package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_01_07 extends DuplicatedMappingExceptionHandler_01_06 {

	@ExceptionHandler
	public void e_01_06_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
