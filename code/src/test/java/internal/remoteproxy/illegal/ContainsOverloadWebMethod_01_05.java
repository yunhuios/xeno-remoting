package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class ContainsOverloadWebMethod_01_05 extends ContainsOverloadWebMethod_01_04 {

	@WebMethod
	public void m_01(int i) {
		// Does nothing.
	}
}
