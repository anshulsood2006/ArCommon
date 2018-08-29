package com.arsoft.projects.common.learning.basics.immutable;

public class ImmutableTest {
	public static void main(String[] args) {
		TestImmutableVariable variable = new TestImmutableVariable();
		variable.setA("S");
		variable.setB("B");
		Immutable immutable =new Immutable(10, "Anshul", variable);
		System.out.println(immutable);
		
		immutable.getVariable().setA("Anshul");
		
		System.out.println(immutable);
	}
}
