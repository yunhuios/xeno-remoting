package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class NotPublicWebMethod_01_05 {

	@WebMethod
	static void m_01_05() {
		// Does nothing.
	}
}
