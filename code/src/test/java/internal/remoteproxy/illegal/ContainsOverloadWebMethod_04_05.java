package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class ContainsOverloadWebMethod_04_05 extends ContainsOverloadWebMethod_04_04 {

	@WebMethod
	public void m_04(int i) {
		// Does nothing.
	}
}
