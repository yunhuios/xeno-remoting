package internal.remoteproxy.illegal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class ContainsOverloadWebMethod_03_05 extends ContainsOverloadWebMethod_03_04 {

	@WebMethod
	public static void m_03(int i) {
		// Does nothing.
	}
}
