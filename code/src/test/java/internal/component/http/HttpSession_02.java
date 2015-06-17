package internal.component.http;

import java.util.Enumeration;

import mock.java.util.StringEnumeration;
import mock.javax.servlet.http.MockHttpSession;

public class HttpSession_02 extends MockHttpSession {

	@Override
	public Enumeration<String> getAttributeNames() {
		return new StringEnumeration();
	}
}
