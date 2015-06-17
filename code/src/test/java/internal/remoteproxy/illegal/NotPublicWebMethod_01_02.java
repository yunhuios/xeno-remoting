package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class NotPublicWebMethod_01_02 {

	@WebMethod
	void m_01_02() {
		// Does nothing.
	}
}
