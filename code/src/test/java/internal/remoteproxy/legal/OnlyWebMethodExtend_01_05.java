package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodExtend_01_05 extends OnlyWebMethodExtend_01_04 {

	@WebMethod
	public Object m_01_05_a(boolean f, String s, Object o) {
		return null;
	}

	public Object m_01_05_b() {
		return null;
	}

	@WebMethod
	public int m_01_05_c(int a, int b) {
		return 0;
	}
}
