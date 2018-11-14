package com.arsoft.projects.artutorial.learning.java8.defaultmethod;

public class ClassB implements DefaultMethod {

	@Override
	public String sayHello() {
		return "Hi from Class B";
	}
	
	@Override
	public int defaultMethod() {
		return 12;
	}
}
