package com.arsoft.projects.artutorial.learning.java8.defaultmethod;

public interface DefaultMethod {
	public String sayHello();
	public default int defaultMethod() {
		return 0;
	}
	public static String takeHello(String name) {
		return "Take my Hello: "+name;
	}
}
