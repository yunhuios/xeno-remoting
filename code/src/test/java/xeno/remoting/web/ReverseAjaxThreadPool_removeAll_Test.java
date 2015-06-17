package xeno.remoting.web;

import javax.servlet.AsyncContext;

import mock.javax.servlet.MockAsyncContext;

import org.junit.Assert;
import org.junit.Test;

public class ReverseAjaxThreadPool_removeAll_Test {

	@Test
	public void testIt() {
		final AsyncContext asyncContext1 = new MockAsyncContext();
		final AsyncContext asyncContext2 = new MockAsyncContext();
		final AsyncContext asyncContext3 = new MockAsyncContext();
		final AsyncContext asyncContext4 = new MockAsyncContext();

		ReverseAjaxThreadPool pool = new ReverseAjaxThreadPool();
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "c").isEmpty());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "e").isEmpty());

		pool.removeAll();
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "c").isEmpty());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "e").isEmpty());

		pool.add("a", "b", asyncContext1);
		pool.add("a", "c", asyncContext2);
		pool.add("d", "b", asyncContext3);
		pool.add("a", "e", asyncContext4);
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.removeAll();
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "c").isEmpty());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "e").isEmpty());

		pool.add("a", "b", asyncContext1);
		pool.add("a", "c", asyncContext2);
		pool.add("d", "b", asyncContext3);
		pool.add("a", "e", asyncContext4);
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.removeAll();
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "c").isEmpty());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "e").isEmpty());
	}

	@Test
	public void test2() {
		final AsyncContext asyncContext1 = new MockAsyncContext();
		final AsyncContext asyncContext2 = new MockAsyncContext();

		ReverseAjaxThreadPool pool = new ReverseAjaxThreadPool();
		Assert.assertTrue(pool.get("a", "b").isEmpty());

		pool.add("a", "b", asyncContext1);
		pool.add("a", "b", asyncContext2);
		Assert.assertEquals(2, pool.get("a", "b").size());
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext1));
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext2));

		pool.removeAll();
		Assert.assertEquals(0, pool.get("a", "b").size());
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext1));
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext2));
	}
}
