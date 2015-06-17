package internal.component.http;

import java.util.Enumeration;

import mock.javax.servlet.http.MockHttpSession;

public class HttpSession_01 extends MockHttpSession {

	@Override
	public Enumeration<String> getAttributeNames() {
		return null;
	}
}