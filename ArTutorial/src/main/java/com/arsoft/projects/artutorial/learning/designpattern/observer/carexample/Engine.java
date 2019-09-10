package com.arsoft.projects.artutorial.learning.designpattern.observer.carexample;

public class Engine {
	private int rpm;

	public int getRpm() {
		return rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}

	public Engine(int rpm) {
		super();
		this.rpm = rpm;
	}

	@Override
	public String toString() {
		return "Engine [rpm=" + rpm + "]";
	}

}
