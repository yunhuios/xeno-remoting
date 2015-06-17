package internal.remoteproxy.legal;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;

@RemoteProxy
public class OnlyExceptionHandlerExtend_01_05 extends OnlyExceptionHandlerExtend_01_04 {

	@ExceptionHandler
	public Object e_01_05_a(SQLException ex) {
		return null;
	}

	public Object e_01_05_b(NoSuchElementException ex) {
		return null;
	}

	@ExceptionHandler
	public int e_01_05_c(IndexOutOfBoundsException ex) {
		return 0;
	}
}
