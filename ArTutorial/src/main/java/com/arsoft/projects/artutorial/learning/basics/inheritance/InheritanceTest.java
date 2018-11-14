package com.arsoft.projects.artutorial.learning.basics.inheritance;

public class InheritanceTest {
	public static void main(String[] args) {
		ClassBase base = new ClassChild();
		base.sayHello();
		
		base = new ClassBase();
		base.sayHello();
		
		ClassChild child = new ClassChild();
		child.sayHello();
	}
}
