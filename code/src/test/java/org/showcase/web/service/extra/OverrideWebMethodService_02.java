package org.showcase.web.service.extra;

import xeno.remoting.bind.WebMethod;

public class OverrideWebMethodService_02 extends OverrideWebMethodService_01 {

	@Override
	public String t1() {
		return "t1 in OverrideWebMethodService_02";
	}

	@Override
	@WebMethod
	public String t3() {
		return "t3 in OverrideWebMethodService_02";
	}

	@Override
	@WebMethod
	public String t4() {
		return "t4 in OverrideWebMethodService_02";
	}

	@WebMethod
	public String t6() {
		return "t6 in OverrideWebMethodService_02";
	}

	public static String s1() {
		return "s1 in OverrideWebMethodService_02";
	}

	@WebMethod
	public static String s3() {
		return "s3 in OverrideWebMethodService_02";
	}

	@WebMethod
	public static String s4() {
		return "s4 in OverrideWebMethodService_02";
	}

	@WebMethod
	public static String s6() {
		return "s6 in OverrideWebMethodService_02";
	}
}
