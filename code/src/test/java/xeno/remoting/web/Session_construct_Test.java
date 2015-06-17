package xeno.remoting.web;

import internal.component.http.HttpSession_01;
import internal.component.http.HttpSession_02;

import javax.servlet.http.HttpSession;

import mock.javax.servlet.http.MockHttpSession;

import org.junit.Assert;
import org.junit.Test;

public class Session_construct_Test {

	@Test
	public void testIt() {

		try {
			new Session(null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'session' is null", ex.getMessage());
		}

		final HttpSession instance = new MockHttpSession();

		Session session = new Session(instance);
		Assert.assertEquals(instance, session.getOriginalHttpSession());

		try {
			session.getId();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getId()", ex.getMessage());
		}

		try {
			session.getFirstCreatedTime();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getCreationTime()", ex.getMessage());
		}

		try {
			session.getLastAccessedTime();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getLastAccessedTime()", ex.getMessage());
		}

		try {
			session.invalidate();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: invalidate()", ex.getMessage());
		}

		try {
			session.getMaxInactiveInterval();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getMaxInactiveInterval()", ex.getMessage());
		}

		try {
			session.setMaxInactiveInterval(0);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: setMaxInactiveInterval(int)", ex.getMessage());
		}

		try {
			session.getAttribute(null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getAttribute(String)", ex.getMessage());
		}

		try {
			session.setAttribute(null, null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: setAttribute(String, Object)", ex.getMessage());
		}

		try {
			session.removeAttribute(null);
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: removeAttribute(String)", ex.getMessage());
		}

		try {
			session.getAttributeNames();
			Assert.fail();

		} catch (UnsupportedOperationException ex) {
			Assert.assertEquals("This method has not been implemented: getAttributeNames()", ex.getMessage());
		}
	}

	@Test
	public void testExtra() {
		Session session = new Session(new HttpSession_01());
		Assert.assertEquals(0, session.getAttributeNames().length);

		session = new Session(new HttpSession_02());
		Assert.assertEquals(6, session.getAttributeNames().length);
		Assert.assertEquals("a", session.getAttributeNames()[0]);
		Assert.assertEquals("b", session.getAttributeNames()[1]);
		Assert.assertEquals("c", session.getAttributeNames()[2]);
		Assert.assertEquals("d", session.getAttributeNames()[3]);
		Assert.assertEquals("e", session.getAttributeNames()[4]);
		Assert.assertEquals("f", session.getAttributeNames()[5]);
	}
}
