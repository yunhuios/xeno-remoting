package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class Json2_construct_Test {

	@Test
	public void testNull() throws Exception {

		try {
			new Json2(null, false);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'encoding' is null", ex.getMessage());
		}
	}
}
