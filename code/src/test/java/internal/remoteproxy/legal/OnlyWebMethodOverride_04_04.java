package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodOverride_04_04 extends OnlyWebMethodOverride_04_03 {

	@WebMethod
	public static void m_04_01(int i) {
		// Does nothing.
	}
}
