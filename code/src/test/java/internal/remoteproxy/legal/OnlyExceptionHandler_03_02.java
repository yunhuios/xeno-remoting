package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandler_03_02 {

	@ExceptionHandler
	public void e_03_02_a(ArithmeticException ex) {
		// Does nothing.
	}

	public static void e_03_02_b(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_03_02_c(NoSuchMethodException ex) throws IOException {
		// Does nothing.
	}

	@ExceptionHandler
	public String e_03_02_d(ClassNotFoundException ex) {
		return null;
	}

	@ExceptionHandler
	public static boolean e_03_02_e(FileNotFoundException ex) {
		return false;
	}

	public long e_03_02_f(IOException ex) {
		return 0;
	}
}
