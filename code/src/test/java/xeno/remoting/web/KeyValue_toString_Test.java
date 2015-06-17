package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class KeyValue_toString_Test {

	@Test
	public void testIt() {
		final String key = "a";
		final Boolean value = true;

		KeyValue<String, Boolean> item = new KeyValue<String, Boolean>(key, value);
		Assert.assertEquals("a=true", item.toString());
	}
}
