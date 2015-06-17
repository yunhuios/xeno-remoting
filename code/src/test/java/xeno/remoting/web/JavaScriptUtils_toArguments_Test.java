package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class JavaScriptUtils_toArguments_Test {

	@Test
	public void testTrue() {
		Assert.assertEquals("opts", JavaScriptUtils.toArguments(-2, true));
		Assert.assertEquals("opts", JavaScriptUtils.toArguments(-1, true));
		Assert.assertEquals("opts", JavaScriptUtils.toArguments(0, true));
		Assert.assertEquals("arg0, opts", JavaScriptUtils.toArguments(1, true));
		Assert.assertEquals("arg0, arg1, opts", JavaScriptUtils.toArguments(2, true));
		Assert.assertEquals("arg0, arg1, arg2, arg3, arg4, arg5, arg6, opts", JavaScriptUtils.toArguments(7, true));
	}

	@Test
	public void testFalse() {
		Assert.assertEquals("[], opts", JavaScriptUtils.toArguments(-2, false));
		Assert.assertEquals("[], opts", JavaScriptUtils.toArguments(-1, false));
		Assert.assertEquals("[], opts", JavaScriptUtils.toArguments(0, false));
		Assert.assertEquals("[arg0], opts", JavaScriptUtils.toArguments(1, false));
		Assert.assertEquals("[arg0, arg1], opts", JavaScriptUtils.toArguments(2, false));
		Assert.assertEquals("[arg0, arg1, arg2, arg3, arg4, arg5, arg6], opts", JavaScriptUtils.toArguments(7, false));
	}
}
