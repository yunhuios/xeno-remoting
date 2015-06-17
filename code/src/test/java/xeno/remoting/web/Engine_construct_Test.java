package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class Engine_construct_Test {

	@Test
	public void testNull() throws Exception {

		try {
			new Engine(null, false);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'encoding' is null", ex.getMessage());
		}
	}
}
