package internal.remoteproxy.legal;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OnlyWebMethodOverride_03_04 extends OnlyWebMethodOverride_03_03 {

	@WebMethod
	public void m_03_01(int i) {
		// Does nothing.
	}
}
