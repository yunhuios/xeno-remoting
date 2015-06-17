package internal.remoteproxy.legal;

import java.io.IOException;
import java.sql.SQLException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtendOverload_03_02 extends OnlyExceptionHandlerExtendOverload_03_01 {

	public void e_03_02(SQLException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public static void e_03_02(IOException ex) {
		// Does nothing.
	}
}
