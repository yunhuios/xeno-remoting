package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class Fault_constrcut_Test {

	@Test
	public void testNull() {

		try {
			new Fault(null, "a");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'cause' is null", ex.getMessage());
		}

		try {
			new Fault(null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'cause' is null", ex.getMessage());
		}
	}

	@Test
	public void testIt() {
		final Object o = new Object();
		final IllegalArgumentException e1 = new IllegalArgumentException("a");
		final IllegalStateException e2 = new IllegalStateException();

		Fault fault = new Fault(e1);
		Assert.assertEquals("java.lang.IllegalArgumentException", fault.getType());
		Assert.assertEquals("a", fault.getMessage());
		Assert.assertNull(fault.getData());

		fault = new Fault(e1, null);
		Assert.assertEquals("java.lang.IllegalArgumentException", fault.getType());
		Assert.assertEquals("a", fault.getMessage());
		Assert.assertNull(fault.getData());

		fault = new Fault(e1, "b");
		Assert.assertEquals("java.lang.IllegalArgumentException", fault.getType());
		Assert.assertEquals("a", fault.getMessage());
		Assert.assertEquals("b", fault.getData());

		fault = new Fault(e1, 1);
		Assert.assertEquals("java.lang.IllegalArgumentException", fault.getType());
		Assert.assertEquals("a", fault.getMessage());
		Assert.assertEquals(1, fault.getData());

		fault = new Fault(e1, true);
		Assert.assertEquals("java.lang.IllegalArgumentException", fault.getType());
		Assert.assertEquals("a", fault.getMessage());
		Assert.assertEquals(true, fault.getData());

		fault = new Fault(e1, o);
		Assert.assertEquals("java.lang.IllegalArgumentException", fault.getType());
		Assert.assertEquals("a", fault.getMessage());
		Assert.assertEquals(o, fault.getData());

		fault = new Fault(e2);
		Assert.assertEquals("java.lang.IllegalStateException", fault.getType());
		Assert.assertNull(fault.getMessage());
		Assert.assertNull(fault.getData());

		fault = new Fault(e2, null);
		Assert.assertEquals("java.lang.IllegalStateException", fault.getType());
		Assert.assertNull(fault.getMessage());
		Assert.assertNull(fault.getData());

		fault = new Fault(e2, "b");
		Assert.assertEquals("java.lang.IllegalStateException", fault.getType());
		Assert.assertNull(fault.getMessage());
		Assert.assertEquals("b", fault.getData());

		fault = new Fault(e2, 1);
		Assert.assertEquals("java.lang.IllegalStateException", fault.getType());
		Assert.assertNull(fault.getMessage());
		Assert.assertEquals(1, fault.getData());

		fault = new Fault(e2, true);
		Assert.assertEquals("java.lang.IllegalStateException", fault.getType());
		Assert.assertNull(fault.getMessage());
		Assert.assertEquals(true, fault.getData());

		fault = new Fault(e2, o);
		Assert.assertEquals("java.lang.IllegalStateException", fault.getType());
		Assert.assertNull(fault.getMessage());
		Assert.assertEquals(o, fault.getData());
	}
}
