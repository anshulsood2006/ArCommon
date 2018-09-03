package com.arsoft.projects.common.learning.designpattern.observer;

import java.util.ArrayList;

public class WeatherData implements Subject {
	
	private ArrayList<Observer> observerList;
	private float temp;
	private float humidity;
	private float pressure;
	
	public WeatherData(){
		observerList = new ArrayList<>();
	}
	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer: observerList){
			observer.update(this.temp, this.humidity, this.pressure);
		}
	}

	public void setMeasurement(float temp, float humidity, float pressure){
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		setChanged();
	}
	
	public void setChanged(){
		notifyObservers();
	}
}
