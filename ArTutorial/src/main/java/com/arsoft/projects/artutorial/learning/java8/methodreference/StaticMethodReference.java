package com.arsoft.projects.artutorial.learning.java8.methodreference;

public class StaticMethodReference {
	public abstract interface MyInterface{
		public void draw(String color, int shade);
	}
	
	public static void drawPainting(String color, int shade){
		System.out.println("Color: "+color+" has been used to draw with opacity: "+shade);
	}
	
	public static void main(String[] args) {
		MyInterface myInterface = StaticMethodReference::drawPainting;
		myInterface.draw("Red", 5);
	}
}
