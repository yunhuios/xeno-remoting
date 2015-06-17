package xeno.remoting.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Validate_notNull_Test {

	@Test
	public void test1() {

		try {
			Validate.notNull(null, null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertNull(ex.getMessage());
		}

		try {
			Validate.notNull(null, "");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("", ex.getMessage());
		}

		try {
			Validate.notNull(null, " ");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals(" ", ex.getMessage());
		}

		try {
			Validate.notNull(null, "a");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("a", ex.getMessage());
		}

		final Object o = new Object();
		Assert.assertEquals(o, Validate.notNull(o, null));
		Assert.assertEquals(o, Validate.notNull(o, ""));
		Assert.assertEquals(o, Validate.notNull(o, " "));
		Assert.assertEquals(o, Validate.notNull(o, "a"));
	}

	@Test
	public void test2() {

		try {
			Validate.notNull((Object[]) null, null, null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertNull(ex.getMessage());
		}

		try {
			Validate.notNull((Object[]) null, "", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("", ex.getMessage());
		}

		try {
			Validate.notNull((Object[]) null, " ", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals(" ", ex.getMessage());
		}

		try {
			Validate.notNull((Object[]) null, "a", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("a", ex.getMessage());
		}

		try {
			Validate.notNull(new Object[] { "a", null, "c" }, null, null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertNull(ex.getMessage());
		}

		try {
			Validate.notNull(new Object[] { "a", null, "c" }, null, "");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("", ex.getMessage());
		}

		try {
			Validate.notNull(new Object[] { "a", null, "c" }, null, " ");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals(" ", ex.getMessage());
		}

		try {
			Validate.notNull(new Object[] { "a", null, "c" }, null, "d");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("d", ex.getMessage());
		}

		try {
			Validate.notNull(new Object[] { "a", null, "c" }, null, "d[index]e");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("d[1]e", ex.getMessage());
		}

		try {
			Validate.notNull(new Object[] { "a", null, "c" }, "d", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertNull(ex.getMessage());
		}

		try {
			Validate.notNull(new Object[] { "a", null, "c" }, "d", "");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("", ex.getMessage());
		}

		try {
			Validate.notNull(new Object[] { "a", null, "c" }, "d", " ");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals(" ", ex.getMessage());
		}

		try {
			Validate.notNull(new Object[] { "a", null, "c" }, "d", "e");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("e", ex.getMessage());
		}

		try {
			Validate.notNull(new Object[] { "a", null, "c" }, "d", "e[index]f");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("e[1]f", ex.getMessage());
		}

		final Object[] a = new Object[0];
		Assert.assertArrayEquals(a, Validate.notNull(a, null, null));
		Assert.assertArrayEquals(a, Validate.notNull(a, "", null));
		Assert.assertArrayEquals(a, Validate.notNull(a, " ", null));
		Assert.assertArrayEquals(a, Validate.notNull(a, "a", null));
		Assert.assertArrayEquals(a, Validate.notNull(a, null, null));
		Assert.assertArrayEquals(a, Validate.notNull(a, null, ""));
		Assert.assertArrayEquals(a, Validate.notNull(a, null, " "));
		Assert.assertArrayEquals(a, Validate.notNull(a, null, "a"));

		final Object[] b = new Object[] { "a", "b" };
		Assert.assertArrayEquals(b, Validate.notNull(b, null, null));
		Assert.assertArrayEquals(b, Validate.notNull(b, "", null));
		Assert.assertArrayEquals(b, Validate.notNull(b, " ", null));
		Assert.assertArrayEquals(b, Validate.notNull(b, "a", null));
		Assert.assertArrayEquals(b, Validate.notNull(b, null, null));
		Assert.assertArrayEquals(b, Validate.notNull(b, null, ""));
		Assert.assertArrayEquals(b, Validate.notNull(b, null, " "));
		Assert.assertArrayEquals(b, Validate.notNull(b, null, "a"));

		final Object[] c = new Object[] { "a", new Object[] { "i", null, "k" }, "b" };
		Assert.assertArrayEquals(c, Validate.notNull(c, null, null));
		Assert.assertArrayEquals(c, Validate.notNull(c, "", null));
		Assert.assertArrayEquals(c, Validate.notNull(c, " ", null));
		Assert.assertArrayEquals(c, Validate.notNull(c, "a", null));
		Assert.assertArrayEquals(c, Validate.notNull(c, null, null));
		Assert.assertArrayEquals(c, Validate.notNull(c, null, ""));
		Assert.assertArrayEquals(c, Validate.notNull(c, null, " "));
		Assert.assertArrayEquals(c, Validate.notNull(c, null, "a"));
	}

	@Test
	public void test3() {

		try {
			Validate.notNull((List) null, null, null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertNull(ex.getMessage());
		}

		try {
			Validate.notNull((List) null, "", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("", ex.getMessage());
		}

		try {
			Validate.notNull((List) null, " ", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals(" ", ex.getMessage());
		}

		try {
			Validate.notNull((List) null, "a", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("a", ex.getMessage());
		}

		final Collection l = new ArrayList();
		l.add("a");
		l.add(null);
		l.add("c");

		try {
			Validate.notNull(l, null, null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertNull(ex.getMessage());
		}

		try {
			Validate.notNull(l, null, "");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("", ex.getMessage());
		}

		try {
			Validate.notNull(l, null, " ");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals(" ", ex.getMessage());
		}

		try {
			Validate.notNull(l, null, "d");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("d", ex.getMessage());
		}

		try {
			Validate.notNull(l, null, "d[index]e");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("d[1]e", ex.getMessage());
		}

		try {
			Validate.notNull(l, "d", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertNull(ex.getMessage());
		}

		try {
			Validate.notNull(l, "d", "");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("", ex.getMessage());
		}

		try {
			Validate.notNull(l, "d", " ");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals(" ", ex.getMessage());
		}

		try {
			Validate.notNull(l, "d", "e");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("e", ex.getMessage());
		}

		try {
			Validate.notNull(l, "d", "e[index]f");
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("e[1]f", ex.getMessage());
		}

		final Collection a = new ArrayList();
		Assert.assertEquals(a, Validate.notNull(a, null, null));
		Assert.assertEquals(a, Validate.notNull(a, "", null));
		Assert.assertEquals(a, Validate.notNull(a, " ", null));
		Assert.assertEquals(a, Validate.notNull(a, "a", null));
		Assert.assertEquals(a, Validate.notNull(a, null, null));
		Assert.assertEquals(a, Validate.notNull(a, null, ""));
		Assert.assertEquals(a, Validate.notNull(a, null, " "));
		Assert.assertEquals(a, Validate.notNull(a, null, "a"));

		final Collection b = new ArrayList();
		b.add("a");
		b.add("b");
		Assert.assertEquals(b, Validate.notNull(b, null, null));
		Assert.assertEquals(b, Validate.notNull(b, "", null));
		Assert.assertEquals(b, Validate.notNull(b, " ", null));
		Assert.assertEquals(b, Validate.notNull(b, "a", null));
		Assert.assertEquals(b, Validate.notNull(b, null, null));
		Assert.assertEquals(b, Validate.notNull(b, null, ""));
		Assert.assertEquals(b, Validate.notNull(b, null, " "));
		Assert.assertEquals(b, Validate.notNull(b, null, "a"));

		final Collection c = new ArrayList();
		c.add("a");
		c.add(new Object[] { "i", null, "k" });
		c.add("b");
		Assert.assertEquals(c, Validate.notNull(c, null, null));
		Assert.assertEquals(c, Validate.notNull(c, "", null));
		Assert.assertEquals(c, Validate.notNull(c, " ", null));
		Assert.assertEquals(c, Validate.notNull(c, "a", null));
		Assert.assertEquals(c, Validate.notNull(c, null, null));
		Assert.assertEquals(c, Validate.notNull(c, null, ""));
		Assert.assertEquals(c, Validate.notNull(c, null, " "));
		Assert.assertEquals(c, Validate.notNull(c, null, "a"));
	}
}
