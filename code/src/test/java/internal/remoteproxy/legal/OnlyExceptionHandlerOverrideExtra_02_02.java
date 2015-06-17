package internal.remoteproxy.legal;

import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverrideExtra_02_02 extends OnlyExceptionHandlerOverrideExtra_02_01 {

	@ExceptionHandler
	public static void e_02_01_a(IOException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_02_01_b(Exception ex) {
		// Does nothing.
	}
}
