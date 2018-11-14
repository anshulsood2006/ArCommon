package com.arsoft.projects.artutorial.learning;

public class OveloadingWithBoxing {

	static void m(int i) {
		System.out.println("int");
	}
	
	static void m(Long l){System.out.println("Long");} 

	static void m(Integer i) {
		System.out.println("Integer");
	}

	static void m(Integer... i) {
		System.out.println("Integer...");
	}

	public static void main(String args[]) {
		short s = 30;
		m(s);
		int a = 30;
		m(a); 
	}
}
