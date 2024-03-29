package com.the9.xuhong.domain;

public class Person {
	private Integer id;
	private String name;
	private Integer age;
	
	public Person() {}
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setID(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", id=" + id + ", name=" + name + "]";
	}
}
