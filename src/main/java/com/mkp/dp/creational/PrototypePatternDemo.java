package com.mkp.dp.creational;

public class PrototypePatternDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		PrototypeClass pattern = new PrototypeClass("Munna");
		System.out.println(pattern.getName());

		// clone
		PrototypeClass pattern2 = (PrototypeClass) pattern.clone();
		pattern2.setName("patra");
		System.out.println(pattern2.getName());

		System.out.println(pattern.getName());
	}
}

class PrototypeClass implements Cloneable {
	private String name;

	public PrototypeClass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
