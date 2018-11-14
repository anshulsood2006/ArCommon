package com.arsoft.projects.artutorial.learning.designpatterns.decorator;

public class LuxoryCar extends CarDecorator{

	public LuxoryCar(Car carComponent) {
		super(carComponent);
		System.out.println("Luxory Car");
	}

}
