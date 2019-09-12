package com.arsoft.projects.artutorial.learning.designpattern.observer.carexample;

public class Demo {
	public static void main(String[] args) {
		Rpm rpm = new Rpm(20);
		Engine engine = new Engine(rpm);
		Car car = new Car("car", engine);
		Car1 car1 = new Car1("car1", engine);
		Car2 car2 = new Car2("car2", engine);
		Car3 car3 = new Car3("car3", engine);
		engine.register(car);
		engine.register(car1);
		engine.register(car2);
		engine.register(car3);
		engine.setRpm(new Rpm(30));
		engine.notifyObservers();
	}
}
