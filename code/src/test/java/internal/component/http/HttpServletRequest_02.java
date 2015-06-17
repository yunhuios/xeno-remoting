package internal.component.http;

import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.Cookie;

import mock.java.util.LocaleEnumeration;
import mock.java.util.StringEnumeration;
import mock.javax.servlet.http.MockHttpServletRequest;

public class HttpServletRequest_02 extends MockHttpServletRequest {

	@Override
	public Cookie[] getCookies() {
		Cookie[] c = new Cookie[6];
		c[0] = new Cookie("a", "aa");
		c[1] = new Cookie("b", "bb");
		c[2] = new Cookie("c", "cc");
		c[3] = new Cookie("d", "dd");
		c[4] = new Cookie("e", "ee");
		c[5] = new Cookie("f", "ff");

		return c;
	}

	@Override
	public Enumeration<Locale> getLocales() {
		return new LocaleEnumeration();
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return new StringEnumeration();
	}

	@Override
	public Enumeration<String> getHeaderNames() {
		return new StringEnumeration();
	}
}
