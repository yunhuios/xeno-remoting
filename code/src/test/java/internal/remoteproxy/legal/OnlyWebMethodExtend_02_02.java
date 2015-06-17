package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodExtend_02_02 extends OnlyWebMethodExtend_02_01 {

	@WebMethod
	public static String m_02_02_a(boolean f, Object o) {
		return null;
	}

	public static void m_02_02_b() {
		// Does nothing.
	}
}
