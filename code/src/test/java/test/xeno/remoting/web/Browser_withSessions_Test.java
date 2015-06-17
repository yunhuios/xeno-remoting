package test.xeno.remoting.web;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import test.xeno.remoting.LoggingTestCase;
import xeno.remoting.web.Browser;

public class Browser_withSessions_Test extends LoggingTestCase {

	@Test
	public void testNull1() {

		try {
			Browser.withSession(null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionId' is null", ex.getMessage());
		}

		try {
			Browser.withSessions((String[]) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds' is null", ex.getMessage());
		}

		try {
			Browser.withSessions((Collection<String>) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds' is null", ex.getMessage());
		}
	}

	@Test
	public void testNull2() {

		try {
			Browser.withSessions("a", null, "c");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds[1]' is null", ex.getMessage());
		}

		Collection<String> col = new ArrayList<String>();
		col.add("a");
		col.add(null);
		col.add("c");

		try {
			Browser.withSessions(col);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds[1]' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal() {
		Assert.assertEquals("xeno.remoting.web.SessionFilteredJavaScriptCallback", Browser.withSession("a").getClass().getName());

		Assert.assertEquals("xeno.remoting.web.SessionFilteredJavaScriptCallback", Browser.withSessions().getClass().getName());
		Assert.assertEquals("xeno.remoting.web.SessionFilteredJavaScriptCallback", Browser.withSessions("a").getClass().getName());
		Assert.assertEquals("xeno.remoting.web.SessionFilteredJavaScriptCallback", Browser.withSessions("a", "b").getClass().getName());

		Collection<String> col = new ArrayList<String>();
		Assert.assertEquals("xeno.remoting.web.SessionFilteredJavaScriptCallback", Browser.withSessions(col).getClass().getName());

		col.add("a");
		Assert.assertEquals("xeno.remoting.web.SessionFilteredJavaScriptCallback", Browser.withSessions(col).getClass().getName());

		col.add("c");
		Assert.assertEquals("xeno.remoting.web.SessionFilteredJavaScriptCallback", Browser.withSessions(col).getClass().getName());
	}
}
