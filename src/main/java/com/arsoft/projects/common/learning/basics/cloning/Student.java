package com.arsoft.projects.common.learning.basics.cloning;

class Student implements Cloneable {
	int id;
	String name;
	Course course;

	public Student(int id, String name, Course course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
