package xeno.remoting.web;

import internal.component.model.SimpleEntity_01;

import org.junit.Assert;
import org.junit.Test;

public class JsonUtils_stringify_Test {

	@Test
	public void testIt() throws JsonSerializationException {
		Assert.assertEquals("null", JsonUtils.stringify(null));
		Assert.assertEquals("\"\"", JsonUtils.stringify(""));
		Assert.assertEquals("\" \"", JsonUtils.stringify(" "));
		Assert.assertEquals("\"a\"", JsonUtils.stringify("a"));
		Assert.assertEquals("{\"id\":0,\"name\":null}", JsonUtils.stringify(new SimpleEntity_01()));
		Assert.assertEquals("{\"id\":1,\"name\":\"a\"}", JsonUtils.stringify(new SimpleEntity_01(1, "a")));

		try {
			JsonUtils.stringify(new Object());
			Assert.fail();

		} catch (JsonSerializationException ex) {
			Assert.assertTrue(ex.getMessage().startsWith("Failed to stringify the object: java.lang.Object"));
		}
	}
}
