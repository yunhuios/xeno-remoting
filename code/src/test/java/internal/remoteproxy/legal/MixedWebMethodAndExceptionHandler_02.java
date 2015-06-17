package internal.remoteproxy.legal;

import java.util.List;
import java.util.Map;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
@SuppressWarnings("rawtypes")
public class MixedWebMethodAndExceptionHandler_02 {

	@ExceptionHandler
	public List e_02_a(RuntimeException ex) {
		return null;
	}

	@WebMethod
	public static int m_02_a(Map m, char c, Object o) throws IllegalArgumentException {
		return 0;
	}

	public Object m_02_b(int i) {
		return null;
	}
}
