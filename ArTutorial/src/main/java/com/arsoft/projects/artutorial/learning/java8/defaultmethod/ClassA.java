package com.arsoft.projects.artutorial.learning.java8.defaultmethod;

public class ClassA implements DefaultMethod {

	@Override
	public String sayHello() {
		return "Hi from Class A";
	}
	
	public static String takeHello(String name) {
		return "Take my Hello: "+name;
	}

}
