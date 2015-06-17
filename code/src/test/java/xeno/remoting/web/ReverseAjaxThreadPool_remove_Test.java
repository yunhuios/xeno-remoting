package xeno.remoting.web;

import javax.servlet.AsyncContext;

import mock.javax.servlet.MockAsyncContext;

import org.junit.Assert;
import org.junit.Test;

public class ReverseAjaxThreadPool_remove_Test {

	@Test
	public void testNull1() {

		try {
			new ReverseAjaxThreadPool().remove(null, "b", new MockAsyncContext());
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionId' is null", ex.getMessage());
		}

		try {
			new ReverseAjaxThreadPool().remove("a", null, new MockAsyncContext());
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUri' is null", ex.getMessage());
		}

		try {
			new ReverseAjaxThreadPool().remove("a", "b", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'asyncContext' is null", ex.getMessage());
		}
	}

	@Test
	public void testNull2() {

		try {
			new ReverseAjaxThreadPool().remove(null, "b");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'sessionId' is null", ex.getMessage());
		}

		try {
			new ReverseAjaxThreadPool().remove("a", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'pageUri' is null", ex.getMessage());
		}
	}

	@Test
	public void test11() {
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
		pool.add("a", "e", asyncContext4);
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("aa", "bb", asyncContext1);
		pool.remove("aa", "bb", asyncContext2);
		pool.remove("aa", "bb", asyncContext3);
		pool.remove("aa", "bb", asyncContext4);
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("a", "bb", asyncContext1);
		pool.remove("a", "bb", asyncContext2);
		pool.remove("a", "bb", asyncContext3);
		pool.remove("a", "bb", asyncContext4);
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("aa", "b", asyncContext1);
		pool.remove("aa", "b", asyncContext2);
		pool.remove("aa", "b", asyncContext3);
		pool.remove("aa", "b", asyncContext4);
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("a", "b", asyncContext2);
		pool.remove("a", "b", asyncContext3);
		pool.remove("a", "b", asyncContext4);
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("a", "b", asyncContext1);
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("d", "b", asyncContext1);
		pool.remove("d", "b", asyncContext2);
		pool.remove("d", "b", asyncContext4);
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("d", "b", asyncContext3);
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("a", "e", asyncContext1);
		pool.remove("a", "e", asyncContext2);
		pool.remove("a", "e", asyncContext3);
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("a", "e", asyncContext4);
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "e").isEmpty());

		pool.remove("a", "c", asyncContext1);
		pool.remove("a", "c", asyncContext3);
		pool.remove("a", "c", asyncContext4);
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "e").isEmpty());

		pool.remove("a", "c", asyncContext2);
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
	}

	@Test
	public void test12() {
		final AsyncContext asyncContext1 = new MockAsyncContext();
		final AsyncContext asyncContext2 = new MockAsyncContext();
		final AsyncContext asyncContext3 = new MockAsyncContext();

		ReverseAjaxThreadPool pool = new ReverseAjaxThreadPool();
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "c").isEmpty());

		pool.add("a", "b", asyncContext1);
		pool.add("a", "b", asyncContext2);
		pool.add("a", "b", asyncContext1);
		pool.add("a", "c", asyncContext1);
		Assert.assertEquals(2, pool.get("a", "b").size());
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext1));
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext2));
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext3));

		pool.remove("a", "b", asyncContext3);
		Assert.assertEquals(2, pool.get("a", "b").size());
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext1));
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext2));
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext3));
		Assert.assertEquals(1, pool.get("a", "c").size());
		Assert.assertTrue(pool.get("a", "c").contains(asyncContext1));
		Assert.assertFalse(pool.get("a", "c").contains(asyncContext2));
		Assert.assertFalse(pool.get("a", "c").contains(asyncContext3));

		pool.remove("a", "b", asyncContext1);
		Assert.assertEquals(1, pool.get("a", "b").size());
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext1));
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext2));
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext3));
		Assert.assertEquals(1, pool.get("a", "c").size());
		Assert.assertTrue(pool.get("a", "c").contains(asyncContext1));
		Assert.assertFalse(pool.get("a", "c").contains(asyncContext2));
		Assert.assertFalse(pool.get("a", "c").contains(asyncContext3));
	}

	@Test
	public void test21() {
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
		pool.add("a", "e", asyncContext4);
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("aa", "bb");
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("a", "bb");
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("aa", "b");
		Assert.assertEquals(asyncContext1, pool.get("a", "b").iterator().next());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("a", "b");
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertEquals(asyncContext3, pool.get("d", "b").iterator().next());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("d", "b");
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertEquals(asyncContext4, pool.get("a", "e").iterator().next());

		pool.remove("a", "e");
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertEquals(asyncContext2, pool.get("a", "c").iterator().next());
		Assert.assertTrue(pool.get("d", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "e").isEmpty());

		pool.remove("a", "c");
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
	}

	@Test
	public void test22() {
		final AsyncContext asyncContext1 = new MockAsyncContext();
		final AsyncContext asyncContext2 = new MockAsyncContext();

		ReverseAjaxThreadPool pool = new ReverseAjaxThreadPool();
		Assert.assertTrue(pool.get("a", "b").isEmpty());
		Assert.assertTrue(pool.get("a", "c").isEmpty());

		pool.add("a", "b", asyncContext1);
		pool.add("a", "b", asyncContext2);
		pool.add("a", "b", asyncContext1);
		pool.add("a", "c", asyncContext1);
		Assert.assertEquals(2, pool.get("a", "b").size());
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext1));
		Assert.assertTrue(pool.get("a", "b").contains(asyncContext2));
		Assert.assertEquals(1, pool.get("a", "c").size());
		Assert.assertTrue(pool.get("a", "c").contains(asyncContext1));
		Assert.assertFalse(pool.get("a", "c").contains(asyncContext2));

		pool.remove("a", "b");
		Assert.assertEquals(0, pool.get("a", "b").size());
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext1));
		Assert.assertFalse(pool.get("a", "b").contains(asyncContext2));
		Assert.assertEquals(1, pool.get("a", "c").size());
		Assert.assertTrue(pool.get("a", "c").contains(asyncContext1));
		Assert.assertFalse(pool.get("a", "c").contains(asyncContext2));
	}
}
