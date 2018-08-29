package com.arsoft.projects.common.learning.designpatterns.decorator;

public class DecoratorPatternTest {
	public static void main(String[] args) {
		
		Car car = new SportsCar(new LuxoryCar(new CarComponentImplementation()));
		car.assemble();
	}
}
