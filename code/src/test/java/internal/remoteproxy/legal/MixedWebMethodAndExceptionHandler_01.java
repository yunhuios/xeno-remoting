package internal.remoteproxy.legal;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
@SuppressWarnings("rawtypes")
public class MixedWebMethodAndExceptionHandler_01 {

	@ExceptionHandler
	public static int e_01_a(IOException ex) {
		return 0;
	}

	@ExceptionHandler
	public List e_01_b(RuntimeException ex) {
		return null;
	}

	@WebMethod
	public void m_01_a(int i) {
		// Does nothing.
	}

	public String m_01_b(boolean b, String s) {
		return null;
	}

	@WebMethod
	public static int m_01_c(Map m, char c, Object o) throws IllegalArgumentException {
		return 0;
	}

	@WebMethod
	public Object m_01_d() {
		return null;
	}

	public Object m_01_d(int i) {
		return null;
	}
}
