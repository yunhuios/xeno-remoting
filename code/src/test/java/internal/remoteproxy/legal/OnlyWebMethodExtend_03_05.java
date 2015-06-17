package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodExtend_03_05 extends OnlyWebMethodExtend_03_04 {

	@WebMethod
	public Object m_03_05_a(boolean f, String s, Object o) {
		return null;
	}

	public Object m_03_05_b() {
		return null;
	}

	@WebMethod
	public static int m_03_05_c(int a, int b) {
		return 0;
	}
}
