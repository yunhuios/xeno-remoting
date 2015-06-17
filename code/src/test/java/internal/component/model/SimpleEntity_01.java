package internal.component.model;

public class SimpleEntity_01 {
	private long id = 0;
	private String name = null;

	public SimpleEntity_01(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public SimpleEntity_01() {
		// Does nothing.
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
