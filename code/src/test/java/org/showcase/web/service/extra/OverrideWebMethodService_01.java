package org.showcase.web.service.extra;

import xeno.remoting.bind.WebMethod;

public class OverrideWebMethodService_01 {

	public String t1() {
		return "t1 in OverrideWebMethodService_01";
	}

	@WebMethod
	public String t2() {
		return "t2 in OverrideWebMethodService_01";
	}

	public String t3() {
		return "t3 in OverrideWebMethodService_01";
	}

	@WebMethod
	public String t4() {
		return "t4 in OverrideWebMethodService_01";
	}

	@WebMethod
	public String t5() {
		return "t5 in OverrideWebMethodService_01";
	}

	public static String s1() {
		return "s1 in OverrideWebMethodService_01";
	}

	@WebMethod
	public static String s2() {
		return "s2 in OverrideWebMethodService_01";
	}

	public static String s3() {
		return "s3 in OverrideWebMethodService_01";
	}

	@WebMethod
	public static String s4() {
		return "s4 in OverrideWebMethodService_01";
	}

	@WebMethod
	public static String s5() {
		return "s5 in OverrideWebMethodService_01";
	}
}
