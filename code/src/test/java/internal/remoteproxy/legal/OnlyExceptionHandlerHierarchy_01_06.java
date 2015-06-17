package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_01_06 extends OnlyExceptionHandlerHierarchy_01_04 {

	@ExceptionHandler
	public void e_01_06_a(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_06_b(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_06_c(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_06_d(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_06_e(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
