package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_04_07 extends DuplicatedMappingExceptionHandler_04_06 {

	@ExceptionHandler
	public void e_04_06_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
