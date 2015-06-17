package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerHierarchy_02_01 {

	@ExceptionHandler
	public static void e_02_01_a(RuntimeException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_01_b(Exception ex) {
		// Does noting.
	}

	public static void e_02_01_c(IllegalArgumentException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_01_d(IndexOutOfBoundsException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_01_e(NumberFormatException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_01_f(FileNotFoundException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_01_g(IOException ex) {
		// Does noting.
	}

	@ExceptionHandler
	public static void e_02_01_h(ArrayIndexOutOfBoundsException ex) {
		// Does noting.
	}
}
