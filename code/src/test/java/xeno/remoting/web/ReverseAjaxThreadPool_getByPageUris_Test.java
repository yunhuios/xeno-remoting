package xeno.remoting.web;

import java.util.Set;

import javax.servlet.AsyncContext;

import mock.javax.servlet.MockAsyncContext;

import org.junit.Assert;
import org.junit.Test;

public class ReverseAjaxThreadPool_getByPageUris_Test {

	@Test
	public void testNull() {

		try {
			new ReverseAjaxThreadPool().getByPageUris((String[]) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUris' is null", ex.getMessage());
		}

		try {
			new ReverseAjaxThreadPool().getByPageUris("a", null, "c");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUris[1]' is null", ex.getMessage());
		}

		try {
			new ReverseAjaxThreadPool().getByPageUris(new String[] { "a", "b", null, "d" });
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUris[2]' is null", ex.getMessage());
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
		pool.add("s2", "p1", asyncContext2);
		pool.add("s3", "p1", asyncContext3);
		pool.add("s4", "p1", asyncContext4);
		pool.add("s5", "p1", asyncContext2);
		pool.add("s1", "p2", asyncContext5);
		pool.add("s2", "p2", asyncContext6);
		pool.add("s3", "p2", asyncContext7);
		pool.add("s4", "p2", asyncContext8);
		pool.add("s5", "p2", asyncContext1);
		pool.add("s1", "p3", asyncContext6);
		pool.add("s2", "p3", asyncContext5);
		pool.add("s3", "p3", asyncContext4);
		pool.add("s4", "p3", asyncContext8);
		pool.add("s5", "p3", asyncContext9);

		Set<AsyncContext> result = pool.getByPageUris("p0");
		Assert.assertEquals(0, result.size());

		result = pool.getByPageUris("p1");
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

		result = pool.getByPageUris("p2");
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

		result = pool.getByPageUris("p3");
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

		result = pool.getByPageUris("p1", "p2");
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

		result = pool.getByPageUris("p1", "p3");
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

		result = pool.getByPageUris("p2", "p3");
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

		result = pool.getByPageUris("p1", "p2", "p3");
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

		result = pool.getByPageUris("p2", "p3", "p2");
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
		Assert.assertTrue(pool.getByPageUris("a").isEmpty());

		pool.add("b", "a", asyncContext1);
		pool.add("b", "a", asyncContext2);
		pool.add("c", "a", asyncContext3);
		pool.add("a", "b", asyncContext4);
		Assert.assertEquals(3, pool.getByPageUris("a").size());
		Assert.assertTrue(pool.getByPageUris("a").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("a").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("a").contains(asyncContext3));
		Assert.assertFalse(pool.getByPageUris("a").contains(asyncContext4));
	}
}
