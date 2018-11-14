package com.arsoft.projects.artutorial.learning.basics.methodoverloading;

public class MethodOverloading {
	
	public String methodA(){
		System.out.println("method called");
		return "method";
	}
	
	public int methodA(int A){
		System.out.println("method called");
		return 5;
	}
	
	public int methodB(){
		return 4;
	}
	
	public static int methodB(int x){
		return 4;
	}
}
