package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_01_13 extends OnlyExceptionHandlerHierarchy_01_11 {

	public void e_01_13_a(IllegalArgumentException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_13_b(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_13_c(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_13_d(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_13_e(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_13_f(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
