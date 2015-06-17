package internal.remoteproxy.legal;

import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverrideExtra_01_02 extends OnlyExceptionHandlerOverrideExtra_01_01 {

	@ExceptionHandler
	public void e_01_01_a(IOException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public void e_01_01_b(Exception ex) {
		// Does nothing.
	}
}
