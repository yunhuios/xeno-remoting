package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class StringUtils_splitItems_Test {

	@Test
	public void testBlankString() {
		Assert.assertEquals(0, StringUtils.splitItems(null).length);
		Assert.assertEquals(0, StringUtils.splitItems("").length);
		Assert.assertEquals(0, StringUtils.splitItems(" ").length);
		Assert.assertEquals(0, StringUtils.splitItems("\n").length);
		Assert.assertEquals(0, StringUtils.splitItems("\t").length);
		Assert.assertEquals(0, StringUtils.splitItems("\r").length);

		Assert.assertEquals(0, StringUtils.splitItems(null, "a").length);
		Assert.assertEquals(0, StringUtils.splitItems("", "a").length);
		Assert.assertEquals(0, StringUtils.splitItems(" ", "a").length);
		Assert.assertEquals(0, StringUtils.splitItems("\n", "a").length);
		Assert.assertEquals(0, StringUtils.splitItems("\t", "a").length);
		Assert.assertEquals(0, StringUtils.splitItems("\r", "a").length);

		Assert.assertEquals(0, StringUtils.splitItems(null, "a", "b").length);
		Assert.assertEquals(0, StringUtils.splitItems("", "a", "b").length);
		Assert.assertEquals(0, StringUtils.splitItems(" ", "a", "b").length);
		Assert.assertEquals(0, StringUtils.splitItems("\n", "a", "b").length);
		Assert.assertEquals(0, StringUtils.splitItems("\t", "a", "b").length);
		Assert.assertEquals(0, StringUtils.splitItems("\r", "a", "b").length);
	}

	@Test
	public void testBlankSeparator() {
		Assert.assertEquals(1, StringUtils.splitItems("a").length);
		Assert.assertEquals(1, StringUtils.splitItems("a", (String[]) null).length);
		Assert.assertEquals(1, StringUtils.splitItems("a", "").length);
		// Assert.assertEquals(1, StringUtils.split("a", " ").length);
		// Assert.assertEquals(1, StringUtils.split("a", "\n").length);
		// Assert.assertEquals(1, StringUtils.split("a", "\t").length);
		// Assert.assertEquals(1, StringUtils.split("a", "\r").length);

		Assert.assertEquals("a", StringUtils.splitItems("a")[0]);
		Assert.assertEquals("a", StringUtils.splitItems("a", (String[]) null)[0]);
		Assert.assertEquals("a", StringUtils.splitItems("a", "")[0]);
		// Assert.assertEquals("a", StringUtils.split("a", " ")[0]);
		// Assert.assertEquals("a", StringUtils.split("a", "\n")[0]);
		// Assert.assertEquals("a", StringUtils.split("a", "\t")[0]);
		// Assert.assertEquals("a", StringUtils.split("a", "\r")[0]);

		Assert.assertEquals("a", StringUtils.splitItems(" a")[0]);
		Assert.assertEquals("a", StringUtils.splitItems(" a", (String[]) null)[0]);
		Assert.assertEquals("a", StringUtils.splitItems(" a", "")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a", " ")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a", "\n")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a", "\t")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a", "\r")[0]);

		Assert.assertEquals("a", StringUtils.splitItems("a ")[0]);
		Assert.assertEquals("a", StringUtils.splitItems("a ", (String[]) null)[0]);
		Assert.assertEquals("a", StringUtils.splitItems("a ", "")[0]);
		// Assert.assertEquals("a", StringUtils.split("a ", " ")[0]);
		// Assert.assertEquals("a", StringUtils.split("a ", "\n")[0]);
		// Assert.assertEquals("a", StringUtils.split("a ", "\t")[0]);
		// Assert.assertEquals("a", StringUtils.split("a ", "\r")[0]);

		Assert.assertEquals("a", StringUtils.splitItems(" a ")[0]);
		Assert.assertEquals("a", StringUtils.splitItems(" a ", (String[]) null)[0]);
		Assert.assertEquals("a", StringUtils.splitItems(" a ", "")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a ", " ")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a ", "\n")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a ", "\t")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a ", "\r")[0]);

		Assert.assertEquals(1, StringUtils.splitItems("a", "", "").length);
		// Assert.assertEquals(1, StringUtils.split("a", " ", " ").length);
		// Assert.assertEquals(1, StringUtils.split("a", "\n", "\n").length);
		// Assert.assertEquals(1, StringUtils.split("a", "\t", "\t").length);
		// Assert.assertEquals(1, StringUtils.split("a", "\r", "\r").length);

		Assert.assertEquals("a", StringUtils.splitItems("a", "", "")[0]);
		// Assert.assertEquals("a", StringUtils.split("a", " ", " ")[0]);
		// Assert.assertEquals("a", StringUtils.split("a", "\n", "\n")[0]);
		// Assert.assertEquals("a", StringUtils.split("a", "\t", "\t")[0]);
		// Assert.assertEquals("a", StringUtils.split("a", "\r", "\r")[0]);

		Assert.assertEquals("a", StringUtils.splitItems(" a", "", "")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a", " ", " ")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a", "\n", "\n")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a", "\t", "\t")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a", "\r", "\r")[0]);

		Assert.assertEquals("a", StringUtils.splitItems("a ", "", "")[0]);
		// Assert.assertEquals("a", StringUtils.split("a ", " ", " ")[0]);
		// Assert.assertEquals("a", StringUtils.split("a ", "\n", "\n")[0]);
		// Assert.assertEquals("a", StringUtils.split("a ", "\t", "\t")[0]);
		// Assert.assertEquals("a", StringUtils.split("a ", "\r", "\r")[0]);

		Assert.assertEquals("a", StringUtils.splitItems(" a ", "", "")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a ", " ", " ")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a ", "\n", "\n")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a ", "\t", "\t")[0]);
		// Assert.assertEquals("a", StringUtils.split(" a ", "\r", "\r")[0]);
	}

	@Test
	public void testNormal() {
		Assert.assertEquals(2, StringUtils.splitItems("abc", "b").length);
		Assert.assertEquals("a", StringUtils.splitItems("abc", "b")[0]);
		Assert.assertEquals("c", StringUtils.splitItems("abc", "b")[1]);

		Assert.assertEquals(3, StringUtils.splitItems("abcdefgh", "b", "e", "f").length);
		Assert.assertEquals("a", StringUtils.splitItems("abcdefgh", "b", "e", "f")[0]);
		Assert.assertEquals("cd", StringUtils.splitItems("abcdefgh", "b", "e", "f")[1]);
		Assert.assertEquals("gh", StringUtils.splitItems("abcdefgh", "b", "e", "f")[2]);

		Assert.assertEquals(0, StringUtils.splitItems(" \n  \r\n\t", "\n").length);
		Assert.assertEquals(0, StringUtils.splitItems(" \n  \r\n\t", " ").length);

		Assert.assertEquals(3, StringUtils.splitItems(" ab b cdeabfgeab AB  \r\n\t", "ab").length);
		Assert.assertEquals("b cde", StringUtils.splitItems(" ab b cdeabfgeab AB  \r\n\t", "ab")[0]);
		Assert.assertEquals("fge", StringUtils.splitItems(" ab b cdeabfgeab AB  \r\n\t", "ab")[1]);
		Assert.assertEquals("AB", StringUtils.splitItems(" ab b cdeabfgeab AB  \r\n\t", "ab")[2]);

		Assert.assertEquals(2, StringUtils.splitItems(" ab b cdeabfgeab AB  \r\n\t", "ab", "fge").length);
		Assert.assertEquals("b cde", StringUtils.splitItems(" ab b cdeabfgeab AB  \r\n\t", "ab", "fge")[0]);
		Assert.assertEquals("AB", StringUtils.splitItems(" ab b cdeabfgeab AB  \r\n\t", "ab", "fge")[1]);

		Assert.assertEquals(1, StringUtils.splitItems(" ab b cdeabfgeab AB  \r\n\t", " ab").length);
		Assert.assertEquals("b cdeabfgeab AB", StringUtils.splitItems(" ab b cdeabfgeab AB  \r\n\t", " ab")[0]);

		Assert.assertEquals(3, StringUtils.splitItems("ab\n\\acd\n\rcde", "\n").length);
		Assert.assertEquals("ab", StringUtils.splitItems("ab\n\\acd\n\rcde", "\n")[0]);
		Assert.assertEquals("\\acd", StringUtils.splitItems("ab\n\\acd\n\rcde", "\n")[1]);
		Assert.assertEquals("cde", StringUtils.splitItems("ab\n\\acd\n\rcde", "\n")[2]);

		Assert.assertEquals(1, StringUtils.splitItems("ab\n\\acd\n\rcde", " \n").length);
		Assert.assertEquals("ab\n\\acd\n\rcde", StringUtils.splitItems("ab\n\\acd\n\rcde", " \n")[0]);

		Assert.assertEquals(6, StringUtils.splitItems("a1bc1da2bc2da3bc3d", "b", "d", "2").length);
		Assert.assertEquals("a1", StringUtils.splitItems("a1bc1da2bc2da3bc3d", "b", "d", "2")[0]);
		Assert.assertEquals("c1", StringUtils.splitItems("a1bc1da2bc2da3bc3d", "b", "d", "2")[1]);
		Assert.assertEquals("a", StringUtils.splitItems("a1bc1da2bc2da3bc3d", "b", "d", "2")[2]);
		Assert.assertEquals("c", StringUtils.splitItems("a1bc1da2bc2da3bc3d", "b", "d", "2")[3]);
		Assert.assertEquals("a3", StringUtils.splitItems("a1bc1da2bc2da3bc3d", "b", "d", "2")[4]);
		Assert.assertEquals("c3", StringUtils.splitItems("a1bc1da2bc2da3bc3d", "b", "d", "2")[5]);
	}

	@Test
	public void testDuplicated() {
		String s = "a;b;ab;abc\na;c";
		String[] p = { ";", "\n" };
		Assert.assertEquals(5, StringUtils.splitItems(s, p).length);
		Assert.assertEquals("a", StringUtils.splitItems(s, p)[0]);
		Assert.assertEquals("b", StringUtils.splitItems(s, p)[1]);
		Assert.assertEquals("ab", StringUtils.splitItems(s, p)[2]);
		Assert.assertEquals("abc", StringUtils.splitItems(s, p)[3]);
		Assert.assertEquals("c", StringUtils.splitItems(s, p)[4]);
	}
}
