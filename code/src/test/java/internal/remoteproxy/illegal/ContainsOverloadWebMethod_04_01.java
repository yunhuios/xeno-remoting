package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class ContainsOverloadWebMethod_04_01 {

	@WebMethod
	public static void m_04() {
		// Does nothing.
	}

	@WebMethod
	public void m_04(int i) {
		// Does nothing.
	}
}
