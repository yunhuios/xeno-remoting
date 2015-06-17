package mock.java.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

public class LocaleEnumeration implements Enumeration<Locale> {
	private List<Locale> data = new ArrayList<Locale>();
	private int cursor = 0;

	public LocaleEnumeration() {
		data.add(new Locale("a"));
		data.add(new Locale("b"));
		data.add(new Locale("c"));
		data.add(new Locale("d"));
		data.add(new Locale("e"));
		data.add(new Locale("f"));
	}

	@Override
	public boolean hasMoreElements() {
		return cursor < data.size();
	}

	@Override
	public Locale nextElement() {
		Locale element = data.get(cursor);

		cursor += 1;

		return element;
	}
}
