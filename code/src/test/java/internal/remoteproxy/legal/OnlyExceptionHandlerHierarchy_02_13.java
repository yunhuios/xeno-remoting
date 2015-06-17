package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_02_13 extends OnlyExceptionHandlerHierarchy_02_11 {

	public static void e_02_13_a(IllegalArgumentException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_13_b(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_13_c(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_13_d(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_13_e(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_13_f(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
