package internal.remoteproxy.legal;

import java.io.IOException;
import java.util.List;

import xeno.remoting.bind.ExceptionHandler;
import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
@SuppressWarnings("rawtypes")
public class MixedWebMethodAndExceptionHandler_04 extends MixedWebMethodAndExceptionHandler_03 {

	@ExceptionHandler
	public List e_04_a(IOException ex) {
		return null;
	}

	@WebMethod
	public Object m_04_a() {
		return null;
	}

	public String m_04_b(boolean b, String s) {
		return null;
	}
}
