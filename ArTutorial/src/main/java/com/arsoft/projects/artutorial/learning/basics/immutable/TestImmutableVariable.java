package com.arsoft.projects.artutorial.learning.basics.immutable;

public class TestImmutableVariable {
	
	public String a;
	public String b;
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	
	public String toString(){
		return a+" "+b;
	}
}
