package com.arsoft.projects.artutorial.learning.designpattern.observer.carexample;

public class Rpm {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Rpm(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "Rpm [value=" + value + "]";
	}
	
}
