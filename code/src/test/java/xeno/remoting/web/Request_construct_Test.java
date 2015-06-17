package xeno.remoting.web;

import internal.component.http.HttpServletRequest_01;
import internal.component.http.HttpServletRequest_02;

import javax.servlet.http.HttpServletRequest;

import mock.javax.servlet.http.MockHttpServletRequest;

import org.junit.Assert;
import org.junit.Test;

public class Request_construct_Test {

	@Test
	public void testIt() {

		try {
			new Request(null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'request' is null", ex.getMessage());
		}

		final HttpServletRequest instance = new MockHttpServletRequest();

		Request request = new Request(instance);
		Assert.assertEquals(instance, request.getOriginalHttpServletRequest());

		try {
			request.getCharacterEncoding();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getCharacterEncoding()", ex.getMessage());
		}

		try {
			request.getContextPath();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getContextPath()", ex.getMessage());
		}

		try {
			request.getServerName();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getServerName()", ex.getMessage());
		}

		try {
			request.getServerPort();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getServerPort()", ex.getMessage());
		}

		try {
			request.getLocalName();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getLocalName()", ex.getMessage());
		}

		try {
			request.getLocalAddress();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getLocalAddr()", ex.getMessage());
		}

		try {
			request.getLocalPort();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getLocalPort()", ex.getMessage());
		}

		try {
			request.getRemoteHost();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getRemoteHost()", ex.getMessage());
		}

		try {
			request.getRemoteAddress();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getRemoteAddr()", ex.getMessage());
		}

		try {
			request.getRemotePort();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getRemotePort()", ex.getMessage());
		}

		try {
			request.getAttribute(null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getAttribute(String)", ex.getMessage());
		}

		try {
			request.setAttribute(null, null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: setAttribute(String, Object)", ex.getMessage());
		}

		try {
			request.removeAttribute(null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: removeAttribute(String)", ex.getMessage());
		}

		try {
			request.getAttributeNames();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getAttributeNames()", ex.getMessage());
		}

		try {
			request.getHeader(null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getHeader(String)", ex.getMessage());
		}

		try {
			request.getHeaderNames();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getHeaderNames()", ex.getMessage());
		}

		try {
			request.getCookies();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getCookies()", ex.getMessage());
		}

		try {
			request.getLocale();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getLocale()", ex.getMessage());
		}

		try {
			request.getLocales();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getLocales()", ex.getMessage());
		}
	}

	@Test
	public void testExtra() {
		Request request = new Request(new HttpServletRequest_01());
		Assert.assertEquals(0, request.getCookies().length);
		Assert.assertEquals(0, request.getLocales().length);
		Assert.assertEquals(0, request.getAttributeNames().length);
		Assert.assertEquals(0, request.getHeaderNames().length);

		request = new Request(new HttpServletRequest_02());
		Assert.assertEquals(6, request.getCookies().length);
		Assert.assertEquals("a", request.getCookies()[0].getName());
		Assert.assertEquals("b", request.getCookies()[1].getName());
		Assert.assertEquals("c", request.getCookies()[2].getName());
		Assert.assertEquals("d", request.getCookies()[3].getName());
		Assert.assertEquals("e", request.getCookies()[4].getName());
		Assert.assertEquals("f", request.getCookies()[5].getName());
		Assert.assertEquals("aa", request.getCookies()[0].getValue());
		Assert.assertEquals("bb", request.getCookies()[1].getValue());
		Assert.assertEquals("cc", request.getCookies()[2].getValue());
		Assert.assertEquals("dd", request.getCookies()[3].getValue());
		Assert.assertEquals("ee", request.getCookies()[4].getValue());
		Assert.assertEquals("ff", request.getCookies()[5].getValue());

		Assert.assertEquals(6, request.getLocales().length);
		Assert.assertEquals("a", request.getLocales()[0].getLanguage());
		Assert.assertEquals("b", request.getLocales()[1].getLanguage());
		Assert.assertEquals("c", request.getLocales()[2].getLanguage());
		Assert.assertEquals("d", request.getLocales()[3].getLanguage());
		Assert.assertEquals("e", request.getLocales()[4].getLanguage());
		Assert.assertEquals("f", request.getLocales()[5].getLanguage());

		Assert.assertEquals(6, request.getAttributeNames().length);
		Assert.assertEquals("a", request.getAttributeNames()[0]);
		Assert.assertEquals("b", request.getAttributeNames()[1]);
		Assert.assertEquals("c", request.getAttributeNames()[2]);
		Assert.assertEquals("d", request.getAttributeNames()[3]);
		Assert.assertEquals("e", request.getAttributeNames()[4]);
		Assert.assertEquals("f", request.getAttributeNames()[5]);

		Assert.assertEquals(6, request.getHeaderNames().length);
		Assert.assertEquals("a", request.getHeaderNames()[0]);
		Assert.assertEquals("b", request.getHeaderNames()[1]);
		Assert.assertEquals("c", request.getHeaderNames()[2]);
		Assert.assertEquals("d", request.getHeaderNames()[3]);
		Assert.assertEquals("e", request.getHeaderNames()[4]);
		Assert.assertEquals("f", request.getHeaderNames()[5]);
	}
}
