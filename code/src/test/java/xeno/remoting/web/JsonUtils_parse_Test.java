package xeno.remoting.web;

import internal.component.model.SimpleEntity_02;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class JsonUtils_parse_Test {

	@Test
	public void test1() throws JsonDeserializationException {
		Assert.assertNull(JsonUtils.parse((String) null, Object.class));

		try {
			JsonUtils.parse("", null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'type' is null", ex.getMessage());
		}

		SimpleEntity_02 p = JsonUtils.parse("{\"id\":0,\"name\":null}", SimpleEntity_02.class);
		Assert.assertEquals(0, p.getId());
		Assert.assertNull(p.getName());

		p = JsonUtils.parse("{\"id\":1,\"name\":\"a\"}", SimpleEntity_02.class);
		Assert.assertEquals(1, p.getId());
		Assert.assertEquals("a", p.getName());

		p = JsonUtils.parse("{\"id\":2,\"name\":\"b\",\"age\":3}", SimpleEntity_02.class);
		Assert.assertEquals(2, p.getId());
		Assert.assertEquals("b", p.getName());

		try {
			JsonUtils.parse("{\"id\":1,\"name\":\"a\"}", List.class);
			Assert.fail();

		} catch (JsonDeserializationException ex) {
			Assert.assertEquals("Failed to parse the string: {\"id\":1,\"name\":\"a\"}", ex.getMessage());
		}
	}

	@Test
	public void test2() throws JsonDeserializationException {
		Assert.assertNull(JsonUtils.parse((InputStream) null, Object.class));

		try {
			JsonUtils.parse(new ByteArrayInputStream("".getBytes()), null);
			Assert.fail();

		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("The 'type' is null", ex.getMessage());
		}

		SimpleEntity_02 p = JsonUtils.parse(new ByteArrayInputStream("{\"id\":0,\"name\":null}".getBytes()), SimpleEntity_02.class);
		Assert.assertEquals(0, p.getId());
		Assert.assertNull(p.getName());

		p = JsonUtils.parse(new ByteArrayInputStream("{\"id\":1,\"name\":\"a\"}".getBytes()), SimpleEntity_02.class);
		Assert.assertEquals(1, p.getId());
		Assert.assertEquals("a", p.getName());

		p = JsonUtils.parse(new ByteArrayInputStream("{\"id\":2,\"name\":\"b\",\"age\":3}".getBytes()), SimpleEntity_02.class);
		Assert.assertEquals(2, p.getId());
		Assert.assertEquals("b", p.getName());

		try {
			JsonUtils.parse(new ByteArrayInputStream("{\"id\":1,\"name\":\"a\"}".getBytes()), List.class);
			Assert.fail();

		} catch (JsonDeserializationException ex) {
			Assert.assertTrue(ex.getMessage().startsWith("Failed to parse the stream: java.io.ByteArrayInputStream"));
		}
	}
}
