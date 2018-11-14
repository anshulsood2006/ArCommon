package com.arsoft.projects.artutorial.learning;

public interface ArDefaultMethodInterface {
	default int getInteger() {
		System.out.println("Default method");
		return 0;
	}
	
	static int  getStaticInteger() {
		System.out.println("Static method");
		return 0;
	}
	
	/*private int getPrivateInteger(){
		System.out.println("Static method");
		return 0;
	}*/
	
}
