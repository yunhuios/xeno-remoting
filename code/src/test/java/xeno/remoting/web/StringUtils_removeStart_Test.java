package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class StringUtils_removeStart_Test {

	@Test
	public void testIt() {
		Assert.assertEquals(null, StringUtils.removeStart(null, null));
		Assert.assertEquals(null, StringUtils.removeStart(null, "a"));
		Assert.assertEquals("a", StringUtils.removeStart("a", null));

		Assert.assertEquals("", StringUtils.removeStart("", ""));
		Assert.assertEquals("", StringUtils.removeStart("", "a"));
		Assert.assertEquals("a", StringUtils.removeStart("a", ""));

		Assert.assertEquals("", StringUtils.removeStart("a", "a"));
		Assert.assertEquals("abaa", StringUtils.removeStart("aabaa", "a"));
		Assert.assertEquals("baa", StringUtils.removeStart("aabaa", "aa"));

		Assert.assertEquals("a", StringUtils.removeStart("a", "A"));
		Assert.assertEquals("aabaa", StringUtils.removeStart("aabaa", "A"));
		Assert.assertEquals("aabaa", StringUtils.removeStart("aabaa", "Aa"));

		Assert.assertEquals(" ", StringUtils.removeStart(" a ", " a"));
		Assert.assertEquals("abaa ", StringUtils.removeStart(" aabaa ", " a"));
		Assert.assertEquals("baa ", StringUtils.removeStart(" aabaa ", " aa"));

		Assert.assertEquals(" a ", StringUtils.removeStart(" a ", " A"));
		Assert.assertEquals(" aabaa ", StringUtils.removeStart(" aabaa ", " A"));
		Assert.assertEquals(" aabaa ", StringUtils.removeStart(" aabaa ", " Aa"));

		Assert.assertEquals(" a ", StringUtils.removeStart(" a ", "a "));
		Assert.assertEquals(" aabaa ", StringUtils.removeStart(" aabaa ", "a "));
		Assert.assertEquals(" aabaa ", StringUtils.removeStart(" aabaa ", "aa "));

		Assert.assertEquals(" a ", StringUtils.removeStart(" a ", "A "));
		Assert.assertEquals(" aabaa ", StringUtils.removeStart(" aabaa ", "A "));
		Assert.assertEquals(" aabaa ", StringUtils.removeStart(" aabaa ", "Aa "));

		Assert.assertEquals("abc", StringUtils.removeStart("abc", "b"));
	}
}
