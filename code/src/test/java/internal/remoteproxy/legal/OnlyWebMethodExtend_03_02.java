package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodExtend_03_02 extends OnlyWebMethodExtend_03_01 {

	@WebMethod
	public static String m_03_02_a(boolean f, Object o) {
		return null;
	}

	public static void m_03_02_b() {
		// Does nothing.
	}
}
