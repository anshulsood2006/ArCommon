package com.arsoft.projects.artutorial.learning.designpatterns.decorator;

public class SportsCar extends CarDecorator{

	public SportsCar(Car carComponent) {
		super(carComponent);
		System.out.println("Sports Car");
	}

}
