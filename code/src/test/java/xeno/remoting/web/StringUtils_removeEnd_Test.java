package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class StringUtils_removeEnd_Test {

	@Test
	public void testIt() {
		Assert.assertEquals(null, StringUtils.removeEnd(null, null));
		Assert.assertEquals(null, StringUtils.removeEnd(null, "a"));
		Assert.assertEquals("a", StringUtils.removeEnd("a", null));

		Assert.assertEquals("", StringUtils.removeEnd("", ""));
		Assert.assertEquals("", StringUtils.removeEnd("", "a"));
		Assert.assertEquals("a", StringUtils.removeEnd("a", ""));

		Assert.assertEquals("", StringUtils.removeEnd("a", "a"));
		Assert.assertEquals("aaba", StringUtils.removeEnd("aabaa", "a"));
		Assert.assertEquals("aab", StringUtils.removeEnd("aabaa", "aa"));

		Assert.assertEquals("a", StringUtils.removeEnd("a", "A"));
		Assert.assertEquals("aabaa", StringUtils.removeEnd("aabaa", "A"));
		Assert.assertEquals("aabaa", StringUtils.removeEnd("aabaa", "Aa"));

		Assert.assertEquals(" a ", StringUtils.removeEnd(" a ", " a"));
		Assert.assertEquals(" aabaa ", StringUtils.removeEnd(" aabaa ", " a"));
		Assert.assertEquals(" aabaa ", StringUtils.removeEnd(" aabaa ", " aa"));

		Assert.assertEquals(" a ", StringUtils.removeEnd(" a ", " A"));
		Assert.assertEquals(" aabaa ", StringUtils.removeEnd(" aabaa ", " A"));
		Assert.assertEquals(" aabaa ", StringUtils.removeEnd(" aabaa ", " Aa"));

		Assert.assertEquals(" ", StringUtils.removeEnd(" a ", "a "));
		Assert.assertEquals(" aaba", StringUtils.removeEnd(" aabaa ", "a "));
		Assert.assertEquals(" aab", StringUtils.removeEnd(" aabaa ", "aa "));

		Assert.assertEquals(" a ", StringUtils.removeEnd(" a ", "A "));
		Assert.assertEquals(" aabaa ", StringUtils.removeEnd(" aabaa ", "A "));
		Assert.assertEquals(" aabaa ", StringUtils.removeEnd(" aabaa ", "Aa "));

		Assert.assertEquals("abc", StringUtils.removeEnd("abc", "b"));
	}
}
