package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class StringUtils_trimToNull_Test {

	@Test
	public void testIt() {
		Assert.assertNull(StringUtils.trimToNull(null));
		Assert.assertNull(StringUtils.trimToNull(""));
		Assert.assertNull(StringUtils.trimToNull(" "));
		Assert.assertNull(StringUtils.trimToNull("  "));
		Assert.assertNull(StringUtils.trimToNull("\n"));
		Assert.assertNull(StringUtils.trimToNull("\t"));
		Assert.assertNull(StringUtils.trimToNull("\f"));
		Assert.assertNull(StringUtils.trimToNull("\r"));
		Assert.assertNull(StringUtils.trimToNull("\n\n"));
		Assert.assertNull(StringUtils.trimToNull("\t\t"));
		Assert.assertNull(StringUtils.trimToNull("\f\f"));
		Assert.assertNull(StringUtils.trimToNull("\r\r"));
		Assert.assertEquals("a", StringUtils.trimToNull("\na\n"));
		Assert.assertEquals("a", StringUtils.trimToNull("a"));
		Assert.assertEquals("a", StringUtils.trimToNull(" a"));
		Assert.assertEquals("a", StringUtils.trimToNull("a "));
		Assert.assertEquals("a", StringUtils.trimToNull(" a "));
	}
}
