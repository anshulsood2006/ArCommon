package com.arsoft.projects.artutorial.learning.java8.defaultmethod;

public class ClassD {
	public static void main(String[] args) {
		DefaultMethod a = new ClassA();
		System.out.println(a.sayHello());
		System.out.println(a.defaultMethod());
		a = new ClassB();
		System.out.println(a.sayHello());
		System.out.println(a.defaultMethod());
		a = new ClassC();
		System.out.println(a.sayHello());
		System.out.println(a.defaultMethod());
	}
}
