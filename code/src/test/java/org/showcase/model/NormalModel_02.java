package org.showcase.model;

public class NormalModel_02 {
	private NormalModel_01 model = null;
	private int age = 0;

	public NormalModel_01 getInnerModel() {
		return model;
	}

	public void setModel(NormalModel_01 model) {
		this.model = model;
	}

	public int getAge() {
		return age;
	}

	public void setMyAge(int age) {
		this.age = age;
	}
}
