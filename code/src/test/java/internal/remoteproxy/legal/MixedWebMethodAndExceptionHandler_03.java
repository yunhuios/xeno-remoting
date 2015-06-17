package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class MixedWebMethodAndExceptionHandler_03 extends MixedWebMethodAndExceptionHandler_02 {

	@WebMethod
	public void m_03_a(int i) {
		// Does nothing.
	}
}
