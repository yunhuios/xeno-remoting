package xeno.remoting.web;

import javax.servlet.AsyncContext;

import mock.javax.servlet.MockAsyncContext;

import org.junit.Assert;
import org.junit.Test;

public class ReverseAjaxThreadPool_getAll_Test {

	@Test
	public void test1() {
		final AsyncContext asyncContext1 = new MockAsyncContext();
		final AsyncContext asyncContext2 = new MockAsyncContext();
		final AsyncContext asyncContext3 = new MockAsyncContext();
		final AsyncContext asyncContext4 = new MockAsyncContext();

		ReverseAjaxThreadPool pool = new ReverseAjaxThreadPool();
		Assert.assertEquals(0, pool.getAll().size());
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "c").isEmpty());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "e").isEmpty());

		pool.add("a", "b", asyncContext1);
		pool.add("a", "c", asyncContext2);
		pool.add("d", "b", asyncContext3);
		pool.add("a", "e", asyncContext4);
		Assert.assertEquals(4, pool.getAll().size());
		Assert.assertTrue(pool.getAll().contains(asyncContext1));
		Assert.assertTrue(pool.getAll().contains(asyncContext2));
		Assert.assertTrue(pool.getAll().contains(asyncContext3));
		Assert.assertTrue(pool.getAll().contains(asyncContext4));
	}

	@Test
	public void test2() {
		final AsyncContext asyncContext1 = new MockAsyncContext();
		final AsyncContext asyncContext2 = new MockAsyncContext();
		final AsyncContext asyncContext3 = new MockAsyncContext();
		final AsyncContext asyncContext4 = new MockAsyncContext();

		ReverseAjaxThreadPool pool = new ReverseAjaxThreadPool();
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "c").isEmpty());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "e").isEmpty());

		pool.add("a", "b", asyncContext1);
		pool.add("a", "c", asyncContext2);
		pool.add("d", "b", asyncContext3);
		pool.add("a", "e", asyncContext2);
		Assert.assertEquals(3, pool.getAll().size());
		Assert.assertTrue(pool.getAll().contains(asyncContext1));
		Assert.assertTrue(pool.getAll().contains(asyncContext2));
		Assert.assertTrue(pool.getAll().contains(asyncContext3));
		Assert.assertFalse(pool.getAll().contains(asyncContext4));
	}

	@Test
	public void test3() {
		final AsyncContext asyncContext1 = new MockAsyncContext();
		final AsyncContext asyncContext2 = new MockAsyncContext();

		ReverseAjaxThreadPool pool = new ReverseAjaxThreadPool();
		Assert.assertTrue(pool.getAll().isEmpty());

		pool.add("a", "b", asyncContext1);
		pool.add("a", "b", asyncContext2);
		Assert.assertEquals(2, pool.getAll().size());
		Assert.assertTrue(pool.getAll().contains(asyncContext1));
		Assert.assertTrue(pool.getAll().contains(asyncContext2));
	}
}
