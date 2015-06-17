package org.showcase.web.service.extra;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;

@RemoteProxy
public class OverrideWebMethodService_03 extends OverrideWebMethodService_02 {

	@Override
	@WebMethod
	public String t1() {
		return "t1 in OverrideWebMethodService_03";
	}

	@Override
	@WebMethod
	public String t2() {
		return "t2 in OverrideWebMethodService_03";
	}

	@Override
	@WebMethod
	public String t3() {
		return "t3 in OverrideWebMethodService_03";
	}

	@Override
	@WebMethod
	public String t4() {
		return "t4 in OverrideWebMethodService_03";
	}

	@WebMethod
	public static String s1() {
		return "s1 in OverrideWebMethodService_03";
	}

	@WebMethod
	public static String s2() {
		return "s2 in OverrideWebMethodService_03";
	}

	@WebMethod
	public static String s3() {
		return "s3 in OverrideWebMethodService_03";
	}

	@WebMethod
	public static String s4() {
		return "s4 in OverrideWebMethodService_03";
	}
}
