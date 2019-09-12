package com.arsoft.projects.artutorial.learning.designpattern.observer.demo;

public interface Subject {
	public void register(Observer observer);
	public void remove(Observer observer);
	public void notifyObservers(Message message);
}
