package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_01_09 extends DuplicatedMappingExceptionHandler_01_08 {

	@ExceptionHandler
	public void e_01_09_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
