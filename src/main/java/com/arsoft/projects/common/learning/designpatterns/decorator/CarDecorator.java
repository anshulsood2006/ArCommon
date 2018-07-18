package com.arsoft.projects.common.learning.designpatterns.decorator;

public class CarDecorator implements Car{
	protected Car carComponent;
	
	public CarDecorator(Car carComponent){
		this.carComponent = carComponent;
	}

	@Override
	public void assemble() {
		this.carComponent.assemble();		
	}
}
