package com.arsoft.projects.artutorial.learning.designpattern.observer.demo;

public class ObserverPatternDemo {
	public static void main(String[] args) {
		Message message = new Message();
		ConcreteSubject subject = new ConcreteSubject(message);
		ConcreteObserver observer = new ConcreteObserver();
		subject.register(observer);
		subject.notifyObservers(new Message());
	}
}