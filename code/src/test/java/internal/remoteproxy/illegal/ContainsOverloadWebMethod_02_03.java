package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class ContainsOverloadWebMethod_02_03 extends ContainsOverloadWebMethod_02_02 {

	@WebMethod
	public static void m_02(int i) {
		// Does nothing.
	}
}
