package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class MessageServlet_constant_Test {

	@Test
	public void testIt() {
		Assert.assertEquals("/xr", MessageServlet.SERVLET_PATH);
	}
}
