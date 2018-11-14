package com.arsoft.projects.artutorial.learning.basics.cloning;

public class StudentDeepClone implements Cloneable{
	int id;
	String name;
	Course course;

	public StudentDeepClone(int id, String name, Course course) {
		this.id = id;
		this.name = name;
		this.course  = new Course(course.subject1, course.subject2, course.subject3);
	}

	protected Object clone() throws CloneNotSupportedException {
		StudentDeepClone student = new StudentDeepClone(id, name, course);
		return student;
	}
}
