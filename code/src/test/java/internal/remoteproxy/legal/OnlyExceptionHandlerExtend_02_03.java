package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtend_02_03 extends OnlyExceptionHandlerExtend_02_02 {

	@ExceptionHandler
	public static Object e_02_03_a(FileNotFoundException ex) {
		return null;
	}

	public static Object e_02_03_b(IOException ex) {
		return null;
	}

	@ExceptionHandler
	public static int e_02_03_c(InterruptedException ex) {
		return 0;
	}
}
