package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class StringUtils_isNotBlank_Test {

	@Test
	public void testIt() {
		Assert.assertFalse(StringUtils.isNotBlank(null));
		Assert.assertFalse(StringUtils.isNotBlank(""));
		Assert.assertFalse(StringUtils.isNotBlank(" "));
		Assert.assertFalse(StringUtils.isNotBlank("  "));
		Assert.assertFalse(StringUtils.isNotBlank("\n"));
		Assert.assertFalse(StringUtils.isNotBlank("\t"));
		Assert.assertFalse(StringUtils.isNotBlank("\f"));
		Assert.assertFalse(StringUtils.isNotBlank("\r"));
		Assert.assertFalse(StringUtils.isNotBlank("\n\n"));
		Assert.assertFalse(StringUtils.isNotBlank("\t\t"));
		Assert.assertFalse(StringUtils.isNotBlank("\f\f"));
		Assert.assertFalse(StringUtils.isNotBlank("\r\r"));
		Assert.assertTrue(StringUtils.isNotBlank("\na\n"));
		Assert.assertTrue(StringUtils.isNotBlank("a"));
		Assert.assertTrue(StringUtils.isNotBlank(" a"));
		Assert.assertTrue(StringUtils.isNotBlank("a "));
		Assert.assertTrue(StringUtils.isNotBlank(" a "));
	}
}
