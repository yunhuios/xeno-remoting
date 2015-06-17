package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class StringUtils_trimToEmpty_Test {

	@Test
	public void testIt() {
		Assert.assertEquals("", StringUtils.trimToEmpty(null));
		Assert.assertEquals("", StringUtils.trimToEmpty(""));
		Assert.assertEquals("", StringUtils.trimToEmpty(" "));
		Assert.assertEquals("", StringUtils.trimToEmpty("  "));
		Assert.assertEquals("", StringUtils.trimToEmpty("\n"));
		Assert.assertEquals("", StringUtils.trimToEmpty("\t"));
		Assert.assertEquals("", StringUtils.trimToEmpty("\f"));
		Assert.assertEquals("", StringUtils.trimToEmpty("\r"));
		Assert.assertEquals("", StringUtils.trimToEmpty("\n\n"));
		Assert.assertEquals("", StringUtils.trimToEmpty("\t\t"));
		Assert.assertEquals("", StringUtils.trimToEmpty("\f\f"));
		Assert.assertEquals("", StringUtils.trimToEmpty("\r\r"));
		Assert.assertEquals("a", StringUtils.trimToEmpty("\na\n"));
		Assert.assertEquals("a", StringUtils.trimToEmpty("a"));
		Assert.assertEquals("a", StringUtils.trimToEmpty(" a"));
		Assert.assertEquals("a", StringUtils.trimToEmpty("a "));
		Assert.assertEquals("a", StringUtils.trimToEmpty(" a "));
	}
}
