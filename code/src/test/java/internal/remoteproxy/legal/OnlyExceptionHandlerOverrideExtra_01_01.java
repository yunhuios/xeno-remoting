package internal.remoteproxy.legal;

import java.io.FileNotFoundException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverrideExtra_01_01 {

	@ExceptionHandler
	public void e_01_01_a(FileNotFoundException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public void e_01_01_b(IllegalArgumentException ex) {
		// Does nothing.
	}
}
