package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodOverride_04_02 extends OnlyWebMethodOverride_04_01 {

	@WebMethod
	public static void m_04_01(int i) {
		// Does nothing.
	}
}
