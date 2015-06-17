package test.xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

import test.xeno.remoting.LoggingTestCase;
import xeno.remoting.web.Browser;

public class Browser_withAll_Test extends LoggingTestCase {

	@Test
	public void testNormal() {
		Assert.assertEquals("xeno.remoting.web.BroadcastJavaScriptCallback", Browser.withAll().getClass().getName());
	}
}
