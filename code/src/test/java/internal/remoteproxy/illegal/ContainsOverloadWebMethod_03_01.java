package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class ContainsOverloadWebMethod_03_01 {

	@WebMethod
	public void m_03() {
		// Does nothing.
	}

	@WebMethod
	public static void m_03(int i) {
		// Does nothing.
	}
}
