package internal.remoteproxy.illegal;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class DuplicatedMappingExceptionHandler_04_09 extends DuplicatedMappingExceptionHandler_04_08 {

	@ExceptionHandler
	public void e_04_09_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
