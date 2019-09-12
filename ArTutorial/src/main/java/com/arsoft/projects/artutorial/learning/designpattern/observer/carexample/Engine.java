package com.arsoft.projects.artutorial.learning.designpattern.observer.carexample;

import java.util.ArrayList;
import java.util.List;

public class Engine implements Subject{
	
	private Rpm rpm;
	private List<Observer> observerList;

	public Rpm getRpm() {
		return rpm;
	}

	public void setRpm(Rpm rpm) {
		this.rpm = rpm;
	}

	public Engine(Rpm rpm) {
		super();
		this.rpm = rpm;
	}

	@Override
	public String toString() {
		return "Engine [rpm=" + rpm + "]";
	}

	@Override
	public void register(Observer observer) {
		if (observerList == null) {		
			observerList  =new ArrayList<Observer>();
		}
		observerList.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		if (observerList == null || observerList.size() == 0) {		
			return;
		}	
		else {
			observerList.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer observer: observerList) {
			observer.update(rpm);
		}
	}

}
