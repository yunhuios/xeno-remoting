package xeno.remoting.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Fault_stringify_Test {

	@Test
	public void testIt() throws Exception {
		final IllegalArgumentException e1 = new IllegalArgumentException("a");
		final IllegalStateException e2 = new IllegalStateException();

		Assert.assertEquals("{\"data\":null,\"message\":\"a\",\"type\":\"java.lang.IllegalArgumentException\"}", JsonUtils.stringify(new Fault(e1)));
		Assert.assertEquals("{\"data\":null,\"message\":\"a\",\"type\":\"java.lang.IllegalArgumentException\"}", JsonUtils.stringify(new Fault(e1, null)));
		Assert.assertEquals("{\"data\":\"b\",\"message\":\"a\",\"type\":\"java.lang.IllegalArgumentException\"}", JsonUtils.stringify(new Fault(e1, "b")));
		Assert.assertEquals("{\"data\":1,\"message\":\"a\",\"type\":\"java.lang.IllegalArgumentException\"}", JsonUtils.stringify(new Fault(e1, 1)));
		Assert.assertEquals("{\"data\":true,\"message\":\"a\",\"type\":\"java.lang.IllegalArgumentException\"}", JsonUtils.stringify(new Fault(e1, true)));

		Assert.assertEquals("{\"data\":null,\"message\":null,\"type\":\"java.lang.IllegalStateException\"}", JsonUtils.stringify(new Fault(e2)));
		Assert.assertEquals("{\"data\":null,\"message\":null,\"type\":\"java.lang.IllegalStateException\"}", JsonUtils.stringify(new Fault(e2, null)));
		Assert.assertEquals("{\"data\":\"b\",\"message\":null,\"type\":\"java.lang.IllegalStateException\"}", JsonUtils.stringify(new Fault(e2, "b")));
		Assert.assertEquals("{\"data\":1,\"message\":null,\"type\":\"java.lang.IllegalStateException\"}", JsonUtils.stringify(new Fault(e2, 1)));
		Assert.assertEquals("{\"data\":true,\"message\":null,\"type\":\"java.lang.IllegalStateException\"}", JsonUtils.stringify(new Fault(e2, true)));

		Map nest = new HashMap();
		nest.put("code", 123456);
		nest.put("name", "My Name");

		Map data = new HashMap();
		data.put("gender", true);
		data.put("detail", nest);
		data.put("id", "i-abcdefg");

		Assert.assertEquals("{\"data\":{\"id\":\"i-abcdefg\",\"detail\":{\"name\":\"My Name\",\"code\":123456},\"gender\":true},\"message\":\"a\",\"type\":\"java.lang.IllegalArgumentException\"}", JsonUtils.stringify(new Fault(e1, data)));
		Assert.assertEquals("{\"data\":{\"id\":\"i-abcdefg\",\"detail\":{\"name\":\"My Name\",\"code\":123456},\"gender\":true},\"message\":null,\"type\":\"java.lang.IllegalStateException\"}", JsonUtils.stringify(new Fault(e2, data)));
	}
}
