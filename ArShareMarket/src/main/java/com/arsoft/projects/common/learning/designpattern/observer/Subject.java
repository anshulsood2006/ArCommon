package com.arsoft.projects.common.learning.designpattern.observer;

public interface Subject{
	public void addObserver(Observer observer);
	public void deleteObserver(Observer observer);
	public void notifyObservers();
}
