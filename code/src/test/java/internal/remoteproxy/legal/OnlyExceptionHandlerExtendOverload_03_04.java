package internal.remoteproxy.legal;

import java.io.IOException;
import java.sql.SQLException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtendOverload_03_04 extends OnlyExceptionHandlerExtendOverload_03_03 {

	public void e_03_04(SQLException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_03_04(IOException ex) {
		// Does nothing.
	}
}
