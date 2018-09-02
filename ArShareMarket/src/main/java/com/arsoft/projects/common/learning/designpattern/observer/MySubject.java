package com.arsoft.projects.common.learning.designpattern.observer;

import java.util.Observable;

public class MySubject extends Observable{
	Observable observable;
	
	public MySubject(){
		observable = new Observable();
	}
	
	public static void main(String[] args) {
		MySubject mySubject = new MySubject();
		mySubject.setChanged();
	}
}
