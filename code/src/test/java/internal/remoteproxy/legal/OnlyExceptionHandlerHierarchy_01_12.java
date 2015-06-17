package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_01_12 extends OnlyExceptionHandlerHierarchy_01_10 {

	public void e_01_12_a(IllegalArgumentException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_12_b(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_12_c(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_12_d(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_12_e(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_12_f(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
