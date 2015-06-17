package internal.remoteproxy.legal;

import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverrideExtra_03_02 extends OnlyExceptionHandlerOverrideExtra_03_01 {

	@ExceptionHandler
	public static void e_03_01_a(IOException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_03_01_b(Exception ex) {
		// Does nothing.
	}
}
