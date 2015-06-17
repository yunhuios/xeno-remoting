package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class StringUtils_isEmpty_Test {

	@Test
	public void testIt() {
		Assert.assertTrue(StringUtils.isEmpty(null));
		Assert.assertTrue(StringUtils.isEmpty(""));
		Assert.assertFalse(StringUtils.isEmpty(" "));
		Assert.assertFalse(StringUtils.isEmpty("  "));
		Assert.assertFalse(StringUtils.isEmpty("\n"));
		Assert.assertFalse(StringUtils.isEmpty("\t"));
		Assert.assertFalse(StringUtils.isEmpty("\f"));
		Assert.assertFalse(StringUtils.isEmpty("\r"));
		Assert.assertFalse(StringUtils.isEmpty("\n\n"));
		Assert.assertFalse(StringUtils.isEmpty("\t\t"));
		Assert.assertFalse(StringUtils.isEmpty("\f\f"));
		Assert.assertFalse(StringUtils.isEmpty("\r\r"));
		Assert.assertFalse(StringUtils.isEmpty("\na\n"));
		Assert.assertFalse(StringUtils.isEmpty("a"));
		Assert.assertFalse(StringUtils.isEmpty(" a"));
		Assert.assertFalse(StringUtils.isEmpty("a "));
		Assert.assertFalse(StringUtils.isEmpty(" a "));
	}
}
