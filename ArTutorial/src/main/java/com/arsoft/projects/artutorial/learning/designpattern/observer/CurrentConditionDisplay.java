package com.arsoft.projects.artutorial.learning.designpattern.observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
	private float temp;
	private float humidity;
	private float pressure;
	private Subject subject;
	
	public CurrentConditionDisplay(Subject subject){
		this.subject = subject;
		subject.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("CurrentConditionDisplay: Tempt: "+this.temp +" Humidity: "+this.humidity+" Pressure: "+this.pressure);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

}
