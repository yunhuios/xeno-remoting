package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_01_01 {

	@ExceptionHandler
	public void e_01_01_a(RuntimeException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_01_b(Exception ex) {
		// Does noting.
	}

	public void e_01_01_c(IllegalArgumentException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_01_d(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_01_e(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_01_f(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_01_g(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_01_01_h(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
