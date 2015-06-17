package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodOverride_02_04 extends OnlyWebMethodOverride_02_03 {

	@WebMethod
	public static void m_02_01(int i) {
		// Does nothing.
	}
}
