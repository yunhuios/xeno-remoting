package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtend_01_03 extends OnlyExceptionHandlerExtend_01_02 {

	@ExceptionHandler
	public Object e_01_03_a(FileNotFoundException ex) {
		return null;
	}

	public Object e_01_03_b(IOException ex) {
		return null;
	}

	@ExceptionHandler
	public int e_01_03_c(InterruptedException ex) {
		return 0;
	}
}
