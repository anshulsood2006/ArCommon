package com.arsoft.projects.artutorial.learning.designpattern.observer.carexample;

public class Car3 implements Observer{
	
	private String name;
	private Engine engine;
	public Car3(String name, Engine engine) {
		super();
		this.name = name;
		this.engine = engine;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", engine=" + engine + "]";
	}
	@Override
	public void update(Rpm rpm) {
		System.out.println("Rpm of the engines of car "+name+" changed to "+ rpm.getValue());
	}
	
}
