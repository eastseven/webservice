package org.dongq.mvc;

import java.util.UUID;

public class Person {
	private String id;
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
