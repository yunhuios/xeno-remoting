package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class StringUtils_isNotEmpty_Test {

	@Test
	public void testIt() {
		Assert.assertFalse(StringUtils.isNotEmpty(null));
		Assert.assertFalse(StringUtils.isNotEmpty(""));
		Assert.assertTrue(StringUtils.isNotEmpty(" "));
		Assert.assertTrue(StringUtils.isNotEmpty("  "));
		Assert.assertTrue(StringUtils.isNotEmpty("\n"));
		Assert.assertTrue(StringUtils.isNotEmpty("\t"));
		Assert.assertTrue(StringUtils.isNotEmpty("\f"));
		Assert.assertTrue(StringUtils.isNotEmpty("\r"));
		Assert.assertTrue(StringUtils.isNotEmpty("\n\n"));
		Assert.assertTrue(StringUtils.isNotEmpty("\t\t"));
		Assert.assertTrue(StringUtils.isNotEmpty("\f\f"));
		Assert.assertTrue(StringUtils.isNotEmpty("\r\r"));
		Assert.assertTrue(StringUtils.isNotEmpty("\na\n"));
		Assert.assertTrue(StringUtils.isNotEmpty("a"));
		Assert.assertTrue(StringUtils.isNotEmpty(" a"));
		Assert.assertTrue(StringUtils.isNotEmpty("a "));
		Assert.assertTrue(StringUtils.isNotEmpty(" a "));
	}
}
