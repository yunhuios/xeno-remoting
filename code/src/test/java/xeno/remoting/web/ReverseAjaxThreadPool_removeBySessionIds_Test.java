package xeno.remoting.web;

import javax.servlet.AsyncContext;

import mock.javax.servlet.MockAsyncContext;

import org.junit.Assert;
import org.junit.Test;

public class ReverseAjaxThreadPool_removeBySessionIds_Test {

	@Test
	public void testNull() {

		try {
			new ReverseAjaxThreadPool().removeBySessionIds((String[]) null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds' is null", ex.getMessage());
		}

		try {
			new ReverseAjaxThreadPool().removeBySessionIds("a", null, "c");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionIds[1]' is null", ex.getMessage());
		}

		try {
			new ReverseAjaxThreadPool().removeBySessionIds(new String[] { "a", "b", null, "d" });
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
		Assert.assertEquals(asyncContext1, pool.get("s1", "p1").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p2").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("s1", "p3").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s1", "p4").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p5").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s2", "p1").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s2", "p2").iterator().next());
		Assert.assertEquals(asyncContext7, pool.get("s2", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s2", "p4").iterator().next());
		Assert.assertEquals(asyncContext1, pool.get("s2", "p5").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s3", "p1").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s3", "p2").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s3", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s3", "p4").iterator().next());
		Assert.assertEquals(asyncContext9, pool.get("s3", "p5").iterator().next());

		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext9));

		pool.removeBySessionIds("s0");
		Assert.assertEquals(asyncContext1, pool.get("s1", "p1").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p2").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("s1", "p3").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s1", "p4").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p5").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s2", "p1").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s2", "p2").iterator().next());
		Assert.assertEquals(asyncContext7, pool.get("s2", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s2", "p4").iterator().next());
		Assert.assertEquals(asyncContext1, pool.get("s2", "p5").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s3", "p1").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s3", "p2").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s3", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s3", "p4").iterator().next());
		Assert.assertEquals(asyncContext9, pool.get("s3", "p5").iterator().next());

		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext9));

		pool.removeBySessionIds("s1");
		Assert.assertTrue(pool.get("s1", "p1").isEmpty());
		Assert.assertTrue(pool.get("s1", "p2").isEmpty());
		Assert.assertTrue(pool.get("s1", "p3").isEmpty());
		Assert.assertTrue(pool.get("s1", "p4").isEmpty());
		Assert.assertTrue(pool.get("s1", "p5").isEmpty());
		Assert.assertEquals(asyncContext5, pool.get("s2", "p1").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s2", "p2").iterator().next());
		Assert.assertEquals(asyncContext7, pool.get("s2", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s2", "p4").iterator().next());
		Assert.assertEquals(asyncContext1, pool.get("s2", "p5").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s3", "p1").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s3", "p2").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s3", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s3", "p4").iterator().next());
		Assert.assertEquals(asyncContext9, pool.get("s3", "p5").iterator().next());

		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext9));

		pool.removeBySessionIds("s2");
		Assert.assertTrue(pool.get("s1", "p1").isEmpty());
		Assert.assertTrue(pool.get("s1", "p2").isEmpty());
		Assert.assertTrue(pool.get("s1", "p3").isEmpty());
		Assert.assertTrue(pool.get("s1", "p4").isEmpty());
		Assert.assertTrue(pool.get("s1", "p5").isEmpty());
		Assert.assertTrue(pool.get("s2", "p1").isEmpty());
		Assert.assertTrue(pool.get("s2", "p2").isEmpty());
		Assert.assertTrue(pool.get("s2", "p3").isEmpty());
		Assert.assertTrue(pool.get("s2", "p4").isEmpty());
		Assert.assertTrue(pool.get("s2", "p5").isEmpty());
		Assert.assertEquals(asyncContext6, pool.get("s3", "p1").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s3", "p2").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s3", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s3", "p4").iterator().next());
		Assert.assertEquals(asyncContext9, pool.get("s3", "p5").iterator().next());

		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext9));

		pool.removeBySessionIds("s3");
		Assert.assertTrue(pool.get("s1", "p1").isEmpty());
		Assert.assertTrue(pool.get("s1", "p2").isEmpty());
		Assert.assertTrue(pool.get("s1", "p3").isEmpty());
		Assert.assertTrue(pool.get("s1", "p4").isEmpty());
		Assert.assertTrue(pool.get("s1", "p5").isEmpty());
		Assert.assertTrue(pool.get("s2", "p1").isEmpty());
		Assert.assertTrue(pool.get("s2", "p2").isEmpty());
		Assert.assertTrue(pool.get("s2", "p3").isEmpty());
		Assert.assertTrue(pool.get("s2", "p4").isEmpty());
		Assert.assertTrue(pool.get("s2", "p5").isEmpty());
		Assert.assertTrue(pool.get("s3", "p1").isEmpty());
		Assert.assertTrue(pool.get("s3", "p2").isEmpty());
		Assert.assertTrue(pool.get("s3", "p3").isEmpty());
		Assert.assertTrue(pool.get("s3", "p4").isEmpty());
		Assert.assertTrue(pool.get("s3", "p5").isEmpty());

		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext9));
	}

	@Test
	public void testNormal2() {
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
		Assert.assertEquals(asyncContext1, pool.get("s1", "p1").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p2").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("s1", "p3").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s1", "p4").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p5").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s2", "p1").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s2", "p2").iterator().next());
		Assert.assertEquals(asyncContext7, pool.get("s2", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s2", "p4").iterator().next());
		Assert.assertEquals(asyncContext1, pool.get("s2", "p5").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s3", "p1").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s3", "p2").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s3", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s3", "p4").iterator().next());
		Assert.assertEquals(asyncContext9, pool.get("s3", "p5").iterator().next());

		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext9));

		pool.removeBySessionIds("s1", "s2");
		Assert.assertTrue(pool.get("s1", "p1").isEmpty());
		Assert.assertTrue(pool.get("s1", "p2").isEmpty());
		Assert.assertTrue(pool.get("s1", "p3").isEmpty());
		Assert.assertTrue(pool.get("s1", "p4").isEmpty());
		Assert.assertTrue(pool.get("s1", "p5").isEmpty());
		Assert.assertTrue(pool.get("s2", "p1").isEmpty());
		Assert.assertTrue(pool.get("s2", "p2").isEmpty());
		Assert.assertTrue(pool.get("s2", "p3").isEmpty());
		Assert.assertTrue(pool.get("s2", "p4").isEmpty());
		Assert.assertTrue(pool.get("s2", "p5").isEmpty());
		Assert.assertEquals(asyncContext6, pool.get("s3", "p1").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s3", "p2").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s3", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s3", "p4").iterator().next());
		Assert.assertEquals(asyncContext9, pool.get("s3", "p5").iterator().next());

		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext9));
	}

	@Test
	public void testNormal3() {
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
		Assert.assertEquals(asyncContext1, pool.get("s1", "p1").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p2").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("s1", "p3").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s1", "p4").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p5").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s2", "p1").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s2", "p2").iterator().next());
		Assert.assertEquals(asyncContext7, pool.get("s2", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s2", "p4").iterator().next());
		Assert.assertEquals(asyncContext1, pool.get("s2", "p5").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s3", "p1").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s3", "p2").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s3", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s3", "p4").iterator().next());
		Assert.assertEquals(asyncContext9, pool.get("s3", "p5").iterator().next());

		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext9));

		pool.removeBySessionIds("s1", "s3");
		Assert.assertTrue(pool.get("s1", "p1").isEmpty());
		Assert.assertTrue(pool.get("s1", "p2").isEmpty());
		Assert.assertTrue(pool.get("s1", "p3").isEmpty());
		Assert.assertTrue(pool.get("s1", "p4").isEmpty());
		Assert.assertTrue(pool.get("s1", "p5").isEmpty());
		Assert.assertEquals(asyncContext5, pool.get("s2", "p1").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s2", "p2").iterator().next());
		Assert.assertEquals(asyncContext7, pool.get("s2", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s2", "p4").iterator().next());
		Assert.assertEquals(asyncContext1, pool.get("s2", "p5").iterator().next());
		Assert.assertTrue(pool.get("s3", "p1").isEmpty());
		Assert.assertTrue(pool.get("s3", "p2").isEmpty());
		Assert.assertTrue(pool.get("s3", "p3").isEmpty());
		Assert.assertTrue(pool.get("s3", "p4").isEmpty());
		Assert.assertTrue(pool.get("s3", "p5").isEmpty());

		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext9));
	}

	@Test
	public void testNormal4() {
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
		Assert.assertEquals(asyncContext1, pool.get("s1", "p1").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p2").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("s1", "p3").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s1", "p4").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p5").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s2", "p1").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s2", "p2").iterator().next());
		Assert.assertEquals(asyncContext7, pool.get("s2", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s2", "p4").iterator().next());
		Assert.assertEquals(asyncContext1, pool.get("s2", "p5").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s3", "p1").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s3", "p2").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s3", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s3", "p4").iterator().next());
		Assert.assertEquals(asyncContext9, pool.get("s3", "p5").iterator().next());

		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext9));

		pool.removeBySessionIds("s2", "s3");
		Assert.assertEquals(asyncContext1, pool.get("s1", "p1").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p2").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("s1", "p3").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s1", "p4").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p5").iterator().next());
		Assert.assertTrue(pool.get("s2", "p1").isEmpty());
		Assert.assertTrue(pool.get("s2", "p2").isEmpty());
		Assert.assertTrue(pool.get("s2", "p3").isEmpty());
		Assert.assertTrue(pool.get("s2", "p4").isEmpty());
		Assert.assertTrue(pool.get("s2", "p5").isEmpty());
		Assert.assertTrue(pool.get("s3", "p1").isEmpty());
		Assert.assertTrue(pool.get("s3", "p2").isEmpty());
		Assert.assertTrue(pool.get("s3", "p3").isEmpty());
		Assert.assertTrue(pool.get("s3", "p4").isEmpty());
		Assert.assertTrue(pool.get("s3", "p5").isEmpty());

		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext9));
	}

	@Test
	public void testNormal5() {
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
		Assert.assertEquals(asyncContext1, pool.get("s1", "p1").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p2").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("s1", "p3").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s1", "p4").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p5").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s2", "p1").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s2", "p2").iterator().next());
		Assert.assertEquals(asyncContext7, pool.get("s2", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s2", "p4").iterator().next());
		Assert.assertEquals(asyncContext1, pool.get("s2", "p5").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s3", "p1").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s3", "p2").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s3", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s3", "p4").iterator().next());
		Assert.assertEquals(asyncContext9, pool.get("s3", "p5").iterator().next());

		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext9));

		pool.removeBySessionIds("s1", "s2", "s3");
		Assert.assertTrue(pool.get("s1", "p1").isEmpty());
		Assert.assertTrue(pool.get("s1", "p2").isEmpty());
		Assert.assertTrue(pool.get("s1", "p3").isEmpty());
		Assert.assertTrue(pool.get("s1", "p4").isEmpty());
		Assert.assertTrue(pool.get("s1", "p5").isEmpty());
		Assert.assertTrue(pool.get("s2", "p1").isEmpty());
		Assert.assertTrue(pool.get("s2", "p2").isEmpty());
		Assert.assertTrue(pool.get("s2", "p3").isEmpty());
		Assert.assertTrue(pool.get("s2", "p4").isEmpty());
		Assert.assertTrue(pool.get("s2", "p5").isEmpty());
		Assert.assertTrue(pool.get("s3", "p1").isEmpty());
		Assert.assertTrue(pool.get("s3", "p2").isEmpty());
		Assert.assertTrue(pool.get("s3", "p3").isEmpty());
		Assert.assertTrue(pool.get("s3", "p4").isEmpty());
		Assert.assertTrue(pool.get("s3", "p5").isEmpty());

		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext9));
	}

	@Test
	public void testNormal6() {
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
		Assert.assertEquals(asyncContext1, pool.get("s1", "p1").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p2").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("s1", "p3").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s1", "p4").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p5").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s2", "p1").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s2", "p2").iterator().next());
		Assert.assertEquals(asyncContext7, pool.get("s2", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s2", "p4").iterator().next());
		Assert.assertEquals(asyncContext1, pool.get("s2", "p5").iterator().next());
		Assert.assertEquals(asyncContext6, pool.get("s3", "p1").iterator().next());
		Assert.assertEquals(asyncContext5, pool.get("s3", "p2").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s3", "p3").iterator().next());
		Assert.assertEquals(asyncContext8, pool.get("s3", "p4").iterator().next());
		Assert.assertEquals(asyncContext9, pool.get("s3", "p5").iterator().next());

		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertTrue(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext9));

		pool.removeBySessionIds("s2", "s3", "s2");
		Assert.assertEquals(asyncContext1, pool.get("s1", "p1").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p2").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("s1", "p3").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("s1", "p4").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("s1", "p5").iterator().next());
		Assert.assertTrue(pool.get("s2", "p1").isEmpty());
		Assert.assertTrue(pool.get("s2", "p2").isEmpty());
		Assert.assertTrue(pool.get("s2", "p3").isEmpty());
		Assert.assertTrue(pool.get("s2", "p4").isEmpty());
		Assert.assertTrue(pool.get("s2", "p5").isEmpty());
		Assert.assertTrue(pool.get("s3", "p1").isEmpty());
		Assert.assertTrue(pool.get("s3", "p2").isEmpty());
		Assert.assertTrue(pool.get("s3", "p3").isEmpty());
		Assert.assertTrue(pool.get("s3", "p4").isEmpty());
		Assert.assertTrue(pool.get("s3", "p5").isEmpty());

		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext1));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext3));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext4));
		Assert.assertTrue(pool.getBySessionIds("s1").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext6));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext7));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s2").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext5));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext4));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext8));
		Assert.assertFalse(pool.getBySessionIds("s3").contains(asyncContext9));

		Assert.assertTrue(pool.getByPageUris("p1").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext5));
		Assert.assertFalse(pool.getByPageUris("p1").contains(asyncContext6));
		Assert.assertTrue(pool.getByPageUris("p2").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext6));
		Assert.assertFalse(pool.getByPageUris("p2").contains(asyncContext5));
		Assert.assertTrue(pool.getByPageUris("p3").contains(asyncContext3));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext7));
		Assert.assertFalse(pool.getByPageUris("p3").contains(asyncContext4));
		Assert.assertTrue(pool.getByPageUris("p4").contains(asyncContext4));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertFalse(pool.getByPageUris("p4").contains(asyncContext8));
		Assert.assertTrue(pool.getByPageUris("p5").contains(asyncContext2));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext1));
		Assert.assertFalse(pool.getByPageUris("p5").contains(asyncContext9));
	}

	@Test
	public void testNormal7() {
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

		Assert.assertEquals(2, pool.get("a", "b").size());
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext1));
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext2));
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext3));
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext4));

		pool.removeBySessionIds("a");
		Assert.assertEquals(0, pool.getBySessionIds("a").size());
		Assert.assertFalse(pool.getBySessionIds("a").contains(asyncContext1));
		Assert.assertFalse(pool.getBySessionIds("a").contains(asyncContext2));
		Assert.assertFalse(pool.getBySessionIds("a").contains(asyncContext3));
		Assert.assertFalse(pool.getBySessionIds("a").contains(asyncContext4));

		Assert.assertEquals(0, pool.get("a", "b").size());
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext1));
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext2));
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext3));
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext4));
	}
}
