package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class Result_constrcut_Test {

	@Test
	public void testIt() {
		final Object o = new Object();

		Result result = new Result();
		Assert.assertNull(result.getData());

		result = new Result(null);
		Assert.assertNull(result.getData());

		result = new Result("a");
		Assert.assertEquals("a", result.getData());

		result = new Result(1);
		Assert.assertEquals(1, result.getData());

		result = new Result(true);
		Assert.assertEquals(true, result.getData());

		result = new Result(o);
		Assert.assertEquals(o, result.getData());
	}
}
