package mock.java.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class StringEnumeration implements Enumeration<String> {
	private List<String> data = new ArrayList<String>();
	private int cursor = 0;

	public StringEnumeration() {
		data.add("a");
		data.add("b");
		data.add("c");
		data.add("d");
		data.add("e");
		data.add("f");
	}

	@Override
	public boolean hasMoreElements() {
		return cursor < data.size();
	}

	@Override
	public String nextElement() {
		String element = data.get(cursor);

		cursor += 1;

		return element;
	}
}
