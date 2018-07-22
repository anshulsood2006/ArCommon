package com.arsoft.projects.common.learning.oops;

public class ClassA {
	
	public int i;
	protected int j;
	
	public ClassA(){
		System.out.println("constructor of Class A is called");
	}
	
	public void method() {
		System.out.println("method of Class A is called");
	}
	
	public String toString() {
		return i+"-"+j;
	}
}
