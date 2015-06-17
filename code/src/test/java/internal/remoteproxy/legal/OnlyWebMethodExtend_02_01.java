package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodExtend_02_01 {

	public static void m_02_01_a(String s) {
		// Does nothing.
	}

	@WebMethod
	public static int m_02_01_a() {
		return 0;
	}

	@WebMethod
	public static void m_02_01_b(char c) {
		// Does nothing.
	}
}
