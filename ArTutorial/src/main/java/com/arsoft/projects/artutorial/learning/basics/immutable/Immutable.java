package com.arsoft.projects.artutorial.learning.basics.immutable;

public final class Immutable {
	
	
	private final int age;
	private final String name;
	private final TestImmutableVariable variable;
	
	public Immutable(int age, String name, TestImmutableVariable variable){
		this.age = age;
		this.name = name;
		TestImmutableVariable clone = new TestImmutableVariable();
		clone.setA(variable.getA());
		clone.setB(variable.getB());
		this.variable = clone;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public TestImmutableVariable getVariable() {
		TestImmutableVariable clone = new TestImmutableVariable();
		clone.setA(this.variable.getA());
		clone.setB(this.variable.getB());
		return clone;
	}
	
	public String toString(){
		return age+" "+name+" "+variable;
	}
	
}
