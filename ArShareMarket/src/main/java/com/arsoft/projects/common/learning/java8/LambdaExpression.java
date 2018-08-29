package com.arsoft.projects.common.learning.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExpression {
	public static String wildAnimal = "Lion";
	interface HelloWorld{
		String hello(String name);
	};
	
	interface Circle {
		double get(double radius);
	}
	
	static class Animal {
		String name;

		Animal(String name) {
			this.name = name;
		}

		public static int animalCompare(Animal a1, Animal a2) {
			return a1.name.compareTo(a2.name);
		}
		
		public String toString() {
			return name;
		}
	}
	
	public static void main(String[] args) {
		LambdaExpression reference = new LambdaExpression();
		String domesticAnimal = "Cat";
		HelloWorld helloWorld = (String name) -> {return "Hello " + name;};
		System.out.println(helloWorld.hello("Joe"));
		new Thread(() -> {
				System.out.println("Hello from thread"+LambdaExpression.wildAnimal);
				System.out.println("wildAnimal"+domesticAnimal);
			}
		).start();
		Circle circleArea = (double radius) -> Math.PI * radius * radius;
		Circle circleCircumference = (double radius) -> 2 * Math.PI * radius;
		double area = reference.circleOperation(12, circleArea);
		double circumference = reference.circleOperation(10, circleCircumference);
		System.out.println("Area: "+area+" . Circumference: "+circumference);
		Animal[] animalArr = {
        		new Animal("Lion"), 
        		new Animal("Crocodile"), 
        		new Animal("Tiger"), 
        		new Animal("Elephant")};
        
        System.out.println("Before Sort: "+Arrays.toString(animalArr));
        Arrays.sort(animalArr, Animal::animalCompare);
        System.out.println("After Sort: "+Arrays.toString(animalArr));
        List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);
		myList.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+t);
			}
		});
	}
	private double circleOperation(double radius, Circle c) {
		return c.get(radius);
	}
}