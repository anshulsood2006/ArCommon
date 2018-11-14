package com.arsoft.projects.artutorial.learning.basics.cloning;

public class DeepClone {
	public static void main(String[] args) {
		
		Course science = new Course("Physics", "Chemistry", "Biology");
		StudentDeepClone student1 = new StudentDeepClone(111, "John", science);
		StudentDeepClone student2 = null;
		
		try {
			student2 = (StudentDeepClone) student1.clone();
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
