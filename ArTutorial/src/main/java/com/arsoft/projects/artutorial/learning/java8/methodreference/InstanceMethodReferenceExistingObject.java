package com.arsoft.projects.artutorial.learning.java8.methodreference;

public class InstanceMethodReferenceExistingObject {
	public abstract interface MyInterface{
		public void draw(String color, int shade);
	}
	
	public void drawPainting(String color, int shade){
		System.out.println("Color: "+color+" has been used to draw with opacity: "+shade);
	}
	
	public static void main(String[] args) {
		InstanceMethodReferenceExistingObject obj = new InstanceMethodReferenceExistingObject();
		MyInterface myInterface = obj::drawPainting;
		myInterface.draw("Green", 15);
	} 
}
