package xeno.remoting.web;

import java.util.Set;

import javax.servlet.AsyncContext;

import mock.javax.servlet.MockAsyncContext;

import org.junit.Assert;
import org.junit.Test;

public class ReverseAjaxThreadPool_getBySessionIds_Test {

	@Test
	public void testNull() {

		try {
			new ReverseAjaxThreadPool().getBySessionIds((String[]) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds' is null", ex.getMessage());
		}

		try {
			new ReverseAjaxThreadPool().getBySessionIds("a", null, "c");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds[1]' is null", ex.getMessage());
		}

		try {
			new ReverseAjaxThreadPool().getBySessionIds(new String[] { "a", "b", null, "d" });
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds[2]' is null", ex.getMessage());
		}
	}

	@Test
	public void testNormal1() {
		final AsyncContext asyncContext1 = new MockAsyncContext();
		final AsyncContext asyncContext2 = new MockAsyncContext();
		final AsyncContext asyncContext3 = new MockAsyncContext();
		final AsyncContext asyncContext4 = new MockAsyncContext();
		final AsyncContext asyncContext5 = new MockAsyncContext();
		final AsyncContext asyncContext6 = new MockAsyncContext();
		final AsyncContext asyncContext7 = new MockAsyncContext();
		final AsyncContext asyncContext8 = new MockAsyncContext();
		final AsyncContext asyncContext9 = new MockAsyncContext();

		ReverseAjaxThreadPool pool = new ReverseAjaxThreadPool();
		pool.add("s1", "p1", asyncContext1);
		pool.add("s1", "p2", asyncContext2);
		pool.add("s1", "p3", asyncContext3);
		pool.add("s1", "p4", asyncContext4);
		pool.add("s1", "p5", asyncContext2);
		pool.add("s2", "p1", asyncContext5);
		pool.add("s2", "p2", asyncContext6);
		pool.add("s2", "p3", asyncContext7);
		pool.add("s2", "p4", asyncContext8);
		pool.add("s2", "p5", asyncContext1);
		pool.add("s3", "p1", asyncContext6);
		pool.add("s3", "p2", asyncContext5);
		pool.add("s3", "p3", asyncContext4);
		pool.add("s3", "p4", asyncContext8);
		pool.add("s3", "p5", asyncContext9);

		Set<AsyncContext> result = pool.getBySessionIds("s0");
		Assert.assertEquals(0, result.size());

		result = pool.getBySessionIds("s1");
		Assert.assertEquals(4, result.size());
		Assert.assertTrue(result.contains(asyncContext1));
		Assert.assertTrue(result.contains(asyncContext2));
		Assert.assertTrue(result.contains(asyncContext3));
		Assert.assertTrue(result.contains(asyncContext4));
		Assert.assertFalse(result.contains(asyncContext5));
		Assert.assertFalse(result.contains(asyncContext6));
		Assert.assertFalse(result.contains(asyncContext7));
		Assert.assertFalse(result.contains(asyncContext8));
		Assert.assertFalse(result.contains(asyncContext9));

		result = pool.getBySessionIds("s2");
		Assert.assertEquals(5, result.size());
		Assert.assertTrue(result.contains(asyncContext1));
		Assert.assertFalse(result.contains(asyncContext2));
		Assert.assertFalse(result.contains(asyncContext3));
		Assert.assertFalse(result.contains(asyncContext4));
		Assert.assertTrue(result.contains(asyncContext5));
		Assert.assertTrue(result.contains(asyncContext6));
		Assert.assertTrue(result.contains(asyncContext7));
		Assert.assertTrue(result.contains(asyncContext8));
		Assert.assertFalse(result.contains(asyncContext9));

		result = pool.getBySessionIds("s3");
		Assert.assertEquals(5, result.size());
		Assert.assertFalse(result.contains(asyncContext1));
		Assert.assertFalse(result.contains(asyncContext2));
		Assert.assertFalse(result.contains(asyncContext3));
		Assert.assertTrue(result.contains(asyncContext4));
		Assert.assertTrue(result.contains(asyncContext5));
		Assert.assertTrue(result.contains(asyncContext6));
		Assert.assertFalse(result.contains(asyncContext7));
		Assert.assertTrue(result.contains(asyncContext8));
		Assert.assertTrue(result.contains(asyncContext9));

		result = pool.getBySessionIds("s1", "s2");
		Assert.assertEquals(8, result.size());
		Assert.assertTrue(result.contains(asyncContext1));
		Assert.assertTrue(result.contains(asyncContext2));
		Assert.assertTrue(result.contains(asyncContext3));
		Assert.assertTrue(result.contains(asyncContext4));
		Assert.assertTrue(result.contains(asyncContext5));
		Assert.assertTrue(result.contains(asyncContext6));
		Assert.assertTrue(result.contains(asyncContext7));
		Assert.assertTrue(result.contains(asyncContext8));
		Assert.assertFalse(result.contains(asyncContext9));

		result = pool.getBySessionIds("s1", "s3");
		Assert.assertEquals(8, result.size());
		Assert.assertTrue(result.contains(asyncContext1));
		Assert.assertTrue(result.contains(asyncContext2));
		Assert.assertTrue(result.contains(asyncContext3));
		Assert.assertTrue(result.contains(asyncContext4));
		Assert.assertTrue(result.contains(asyncContext5));
		Assert.assertTrue(result.contains(asyncContext6));
		Assert.assertFalse(result.contains(asyncContext7));
		Assert.assertTrue(result.contains(asyncContext8));
		Assert.assertTrue(result.contains(asyncContext9));

		result = pool.getBySessionIds("s2", "s3");
		Assert.assertEquals(7, result.size());
		Assert.assertTrue(result.contains(asyncContext1));
		Assert.assertFalse(result.contains(asyncContext2));
		Assert.assertFalse(result.contains(asyncContext3));
		Assert.assertTrue(result.contains(asyncContext4));
		Assert.assertTrue(result.contains(asyncContext5));
		Assert.assertTrue(result.contains(asyncContext6));
		Assert.assertTrue(result.contains(asyncContext7));
		Assert.assertTrue(result.contains(asyncContext8));
		Assert.assertTrue(result.contains(asyncContext9));

		result = pool.getBySessionIds("s1", "s2", "s3");
		Assert.assertEquals(9, result.size());
		Assert.assertTrue(result.contains(asyncContext1));
		Assert.assertTrue(result.contains(asyncContext2));
		Assert.assertTrue(result.contains(asyncContext3));
		Assert.assertTrue(result.contains(asyncContext4));
		Assert.assertTrue(result.contains(asyncContext5));
		Assert.assertTrue(result.contains(asyncContext6));
		Assert.assertTrue(result.contains(asyncContext7));
		Assert.assertTrue(result.contains(asyncContext8));
		Assert.assertTrue(result.contains(asyncContext9));

		result = pool.getBySessionIds("s2", "s3", "s2");
		Assert.assertEquals(7, result.size());
		Assert.assertTrue(result.contains(asyncContext1));
		Assert.assertFalse(result.contains(asyncContext2));
		Assert.assertFalse(result.contains(asyncContext3));
		Assert.assertTrue(result.contains(asyncContext4));
		Assert.assertTrue(result.contains(asyncContext5));
		Assert.assertTrue(result.contains(asyncContext6));
		Assert.assertTrue(result.contains(asyncContext7));
		Assert.assertTrue(result.contains(asyncContext8));
		Assert.assertTrue(result.contains(asyncContext9));
	}

	@Test
	public void testNormal2() {
		final AsyncContext asyncContext1 = new MockAsyncContext();
		final AsyncContext asyncContext2 = new MockAsyncContext();
		final AsyncContext asyncContext3 = new MockAsyncContext();
		final AsyncContext asyncContext4 = new MockAsyncContext();

		ReverseAjaxThreadPool pool = new ReverseAjaxThreadPool();
		Assert.assertTrue(pool.getBySessionIds("a").isEmpty());

		pool.add("a", "b", asyncContext1);
		pool.add("a", "b", asyncContext2);
		pool.add("a", "c", asyncContext3);
		pool.add("b", "a", asyncContext4);
		Assert.assertEquals(3, pool.getBySessionIds("a").size());
		Assert.assertTrue(pool.getBySessionIds("a").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("a").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("a").contains(asyncContext3));
		Assert.assertFalse(pool.getBySessionIds("a").contains(asyncContext4));
	}
}
