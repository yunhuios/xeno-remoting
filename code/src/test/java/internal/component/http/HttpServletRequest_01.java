package internal.component.http;

import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.Cookie;

import mock.javax.servlet.http.MockHttpServletRequest;

public class HttpServletRequest_01 extends MockHttpServletRequest {

	@Override
	public Cookie[] getCookies() {
		return null;
	}

	@Override
	public Enumeration<Locale> getLocales() {
		return null;
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return null;
	}

	@Override
	public Enumeration<String> getHeaderNames() {
		return null;
	}
}
