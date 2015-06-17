package internal.remoteproxy.legal;

import java.io.IOException;
import java.sql.SQLException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtendOverload_01_04 extends OnlyExceptionHandlerExtendOverload_01_03 {

	public void e_01_04(SQLException ex) {
		// Does nothing.
	}

	@ExceptionHandler
	public void e_01_04(IOException ex) {
		// Does nothing.
	}
}
