package com.arsoft.projects.artutorial.learning.designpattern.observer.demo;

public class ConcreteObserver implements Observer{
	
	@Override
	public void update(Message message) {
		System.out.println("Subject has changed: "+message);
	}
	
}
