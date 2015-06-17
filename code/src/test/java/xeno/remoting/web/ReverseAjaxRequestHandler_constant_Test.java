package xeno.remoting.web;

import org.junit.Assert;
import org.junit.Test;

public class ReverseAjaxRequestHandler_constant_Test {

	@Test
	public void testIt() {
		Assert.assertEquals("/xeno.remoting.web.ReverseAjax.do", ReverseAjaxRequestHandler.PATH_INFO);
		Assert.assertEquals("ReverseAjax.RequestAttribute.ResponseStatusFlag", ReverseAjaxRequestHandler.RESPONSE_STATUS_FLAG_REQUEST_ATTRIBUTE_KEY);
		Assert.assertEquals("ReverseAjax.RequestAttribute.JavaScriptFunction", ReverseAjaxRequestHandler.JAVASCRIPT_FUNCTION_REQUEST_ATTRIBUTE_KEY);
	}
}
