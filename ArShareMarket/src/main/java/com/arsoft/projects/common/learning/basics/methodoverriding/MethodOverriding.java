package com.arsoft.projects.common.learning.basics.methodoverriding;

public class MethodOverriding {
	
	public static void main(String[] args) {
		ClassA a = new ClassA();
		System.out.println(a.method());
		
		a = new ClassB();
		System.out.println(a.method());
	}
}
