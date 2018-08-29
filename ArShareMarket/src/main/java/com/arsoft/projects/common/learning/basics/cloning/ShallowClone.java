package com.arsoft.projects.common.learning.basics.cloning;

public class ShallowClone {
	public static void main(String[] args) {
		Course science = new Course("Physics", "Chemistry", "Biology");
		StudentShallowClone student1 = new StudentShallowClone(111, "John", science);
		StudentShallowClone student2 = null;
		try {
			student2 = (StudentShallowClone) student1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(student1.course.subject3); // Output : Biology
		System.out.println(student2.course.subject3);
		student2.course.subject3 = "Maths";
		System.out.println(student1.course.subject3); // Output : Maths
		System.out.println(student2.course.subject3);
	}
}
