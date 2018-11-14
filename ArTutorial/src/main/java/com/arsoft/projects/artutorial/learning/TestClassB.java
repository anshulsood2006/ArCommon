package com.arsoft.projects.artutorial.learning;

public class TestClassB {
	static {
		System.out.println("Static of TestClassB");
	}
	{
		System.out.println("Instance block of TestClassB");
	}
	
	public TestClassB(){
		System.out.println("Constructor of TestClassB");
	}
}
