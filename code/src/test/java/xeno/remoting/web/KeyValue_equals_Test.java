package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class KeyValue_equals_Test {

	@Test
	public void testDifferentTypes1() {
		KeyValue o1 = new KeyValue("a", "b");
		Object o2 = null;
		Assert.assertFalse(o1.equals(o2));
	}

	@Test
	public void testDifferentTypes2() {
		KeyValue o1 = new KeyValue("a", "b");
		Object o2 = new Object();
		Assert.assertFalse(o1.equals(o2));
	}

	@Test
	public void testSameObject() {
		KeyValue o1 = new KeyValue("a", "b");
		KeyValue o2 = o1;
		Assert.assertTrue(o1.equals(o2));
		Assert.assertTrue(o1.hashCode() == o2.hashCode());
	}

	@Test
	public void testSameType1() {
		KeyValue o1 = new KeyValue("a", "b");
		KeyValue o2 = new KeyValue("a", "c");
		Assert.assertTrue(o1.equals(o2));
		Assert.assertTrue(o1.hashCode() == o2.hashCode());
	}

	@Test
	public void testSameType2() {
		KeyValue o1 = new KeyValue("a", "b");
		KeyValue o2 = new KeyValue("c", "b");
		Assert.assertFalse(o1.equals(o2));
	}
}
