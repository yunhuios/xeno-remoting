package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_03_09 extends OnlyExceptionHandlerHierarchy_03_08 {

	public void e_03_09_a(IllegalArgumentException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_03_09_b(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_03_09_c(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public void e_03_09_d(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_03_09_e(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_03_09_f(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
