package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class KeyValue_construct_Test {

	@Test
	public void testNull() {

		try {
			new KeyValue(null, "b");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'key' is null", ex.getMessage());
		}

		try {
			new KeyValue("a", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'value' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal() {
		final Object key = new Object();
		final Object value = new Object();
		Assert.assertNotEquals(key, value);

		KeyValue<Object, Object> item = new KeyValue<Object, Object>(key, value);
		Assert.assertEquals(key, item.getKey());
		Assert.assertEquals(value, item.getValue());
	}
}
