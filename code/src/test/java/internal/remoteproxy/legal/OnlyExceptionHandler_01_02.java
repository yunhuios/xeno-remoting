package internal.remoteproxy.legal;

import java.io.FileNotFoundException;
import java.io.IOException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandler_01_02 {

	@ExceptionHandler
	public void e_01_02_a(ArithmeticException ex) {
		// Does nothing.
	}

	public void e_01_02_b(IllegalArgumentException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public void e_01_02_c(NoSuchMethodException ex) throws IOException {
		// Does nothing.
	}

	@ExceptionHandler
	public String e_01_02_d(ClassNotFoundException ex) {
		return null;
	}

	@ExceptionHandler
	public boolean e_01_02_e(FileNotFoundException ex) {
		return false;
	}

	public long e_01_02_f(IOException ex) {
		return 0;
	}
}
