package internal.remoteproxy.legal;

import java.io.IOException;
import java.sql.SQLException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerOverload_01_01 {

	@ExceptionHandler
	public void e_01_01(IllegalArgumentException ex) {
		// Does nothing.
	}

	public void e_01_01(ClassNotFoundException ex) {
		// Does nothing.
	}

	public void e_01_01(SQLException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public void e_01_01(IOException ex) {
		// Does nothing.
	}
}
