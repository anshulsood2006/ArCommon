package com.arsoft.projects.artutorial.learning.object;

public class ArTestObject {
	//2018699554
	public int hashCode() {
		return 0;
		
	}
	public static void main(String[] args) {
		ArTestObject ar = new ArTestObject();
		System.out.println(ar.hashCode());
		System.out.println(System.identityHashCode(ar));
	}
}
