package com.arsoft.projects.artutorial.learning.modifiers;

public class ClassA {
	public int publicVariable;
	int defaultVariable;
	private int privateVariable;
	protected int protectedVariable;
	
	public static void main(String[] args) {
		ClassA a = new ClassA();
		System.out.println(a.defaultVariable);
		System.out.println(a.publicVariable);
		System.out.println(a.protectedVariable);
		System.out.println(a.privateVariable);
	}
}
