package com.arsoft.projects.artutorial.learning;

public class TestClassA implements ArDefaultMethodInterface{
	
	static {
		System.out.println("Static of TestClassA");
	}
	{
		System.out.println("Instance block of TestClassA");
	}
	
	public TestClassA(){
		System.out.println("Constructor of TestClassA");
	}
 public static void main(String[] args) {
	TestClassA a = new TestClassA();
	TestClassB b = new TestClassB();
	ArDefaultMethodInterface.getStaticInteger();
	a.getInteger();
	b.toString();
 }
 
 public static int getStaticInteger(){
	 System.out.println("Static method of class");
	 return 0;
 }

}
