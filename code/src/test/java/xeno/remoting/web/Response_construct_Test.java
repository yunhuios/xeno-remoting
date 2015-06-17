package xeno.remoting.web;

import javax.servlet.http.HttpServletResponse;

import mock.javax.servlet.http.MockHttpServletResponse;

import org.junit.Assert;
import org.junit.Test;

public class Response_construct_Test {

	@Test
	public void testIt() {

		try {
			new Response(null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'response' is null", ex.getMessage());
		}

		final HttpServletResponse instance = new MockHttpServletResponse();

		Response response = new Response(instance);
		Assert.assertEquals(instance, response.getOriginalHttpServletResponse());

		try {
			response.getCharacterEncoding();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getCharacterEncoding()", ex.getMessage());
		}

		try {
			response.addCookie(null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: addCookie(Cookie)", ex.getMessage());
		}

		try {
			response.setHeader(null, null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: setHeader(String, String)", ex.getMessage());
		}

		try {
			response.containsHeader(null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: containsHeader(String)", ex.getMessage());
		}

		try {
			response.getLocale();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getLocale()", ex.getMessage());
		}

		try {
			response.setLocale(null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: setLocale(Locale)", ex.getMessage());
		}
	}
}
