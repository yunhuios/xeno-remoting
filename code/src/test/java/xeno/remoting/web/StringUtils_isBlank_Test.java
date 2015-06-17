package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class StringUtils_isBlank_Test {

	@Test
	public void testIt() {
		Assert.assertTrue(StringUtils.isBlank(null));
		Assert.assertTrue(StringUtils.isBlank(""));
		Assert.assertTrue(StringUtils.isBlank(" "));
		Assert.assertTrue(StringUtils.isBlank("  "));
		Assert.assertTrue(StringUtils.isBlank("\n"));
		Assert.assertTrue(StringUtils.isBlank("\t"));
		Assert.assertTrue(StringUtils.isBlank("\f"));
		Assert.assertTrue(StringUtils.isBlank("\r"));
		Assert.assertTrue(StringUtils.isBlank("\n\n"));
		Assert.assertTrue(StringUtils.isBlank("\t\t"));
		Assert.assertTrue(StringUtils.isBlank("\f\f"));
		Assert.assertTrue(StringUtils.isBlank("\r\r"));
		Assert.assertFalse(StringUtils.isBlank("\na\n"));
		Assert.assertFalse(StringUtils.isBlank("a"));
		Assert.assertFalse(StringUtils.isBlank(" a"));
		Assert.assertFalse(StringUtils.isBlank("a "));
		Assert.assertFalse(StringUtils.isBlank(" a "));
	}
}
