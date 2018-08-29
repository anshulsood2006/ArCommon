package com.arsoft.projects.common.learning.oops;

public class ClassB extends ClassA {
	
	public ClassB() {
		System.out.println("constructor of Class B is called");
	}
	
	public void method() {
		System.out.println("method of Class B is called");
	}
	
	public String toString() {
		return i+"-"+j;
	}
	
	public static void main(String[] args) {
		ClassB classb = new ClassB();
		classb.method();
		classb.i = 10;
		classb.j = 15;
		System.out.println(classb);
		ClassA classa = new ClassA();
		classa.method();
		swap(classb, classa);
		System.out.println(classb);
		classa = new ClassB();
		classa.method();
		
	}

	private static void swap(ClassB classb, ClassA classa) {
		classb.i = 15;
		classb.j = 20;
	}
}
