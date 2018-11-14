package com.arsoft.projects.artutorial.learning.error.compilation;

public class Parent {
	static{
		System.out.println("Static block of "+Thread.currentThread().getStackTrace()[1].getClassName() +" class called.");
	}
	
	public Parent(){
		System.out.println("Constructor of "+this.getClass().getName() +" class called.");
	}
	
	public void methodOne(){
		System.out.println("methodOne() of "+this.getClass().getName() +" class called.");
	}
}
