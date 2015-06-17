package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class ContainsOverloadWebMethod_04_03 extends ContainsOverloadWebMethod_04_02 {

	@WebMethod
	public void m_04(int i) {
		// Does nothing.
	}
}
