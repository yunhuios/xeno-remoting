package xeno.remoting.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Result_stringify_Test {

	@Test
	public void testIt() throws Exception {
		Assert.assertEquals("{\"data\":null}", JsonUtils.stringify(new Result()));
		Assert.assertEquals("{\"data\":null}", JsonUtils.stringify(new Result(null)));
		Assert.assertEquals("{\"data\":\"a\"}", JsonUtils.stringify(new Result("a")));
		Assert.assertEquals("{\"data\":1}", JsonUtils.stringify(new Result(1)));
		Assert.assertEquals("{\"data\":true}", JsonUtils.stringify(new Result(true)));

		Map nest = new HashMap();
		nest.put("code", 123456);
		nest.put("name", "My Name");

		Map data = new HashMap();
		data.put("gender", true);
		data.put("detail", nest);
		data.put("id", "i-abcdefg");

		Assert.assertEquals("{\"data\":{\"id\":\"i-abcdefg\",\"detail\":{\"name\":\"My Name\",\"code\":123456},\"gender\":true}}", JsonUtils.stringify(new Result(data)));
	}
}
