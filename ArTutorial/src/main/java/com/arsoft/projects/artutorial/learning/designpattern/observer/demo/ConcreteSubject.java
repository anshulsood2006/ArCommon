package com.arsoft.projects.artutorial.learning.designpattern.observer.demo;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
	private Message message;
	
	ConcreteSubject(Message message){
		this.message = message;
	}
	
	private List<Observer> observerList;
	
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
	public void notifyObservers(Message message) {
		for (Observer observer: observerList) {
			observer.update(message);
		}
	}
}
