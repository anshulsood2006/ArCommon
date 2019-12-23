package com.arsoft.projects.artutorial.learning.standalone.multithreading.staticexamples;

public class StaticExampleMain {
	public static void main(String[] args) {
		Thread myThread1 = new Thread( new MyThread("Anshul"));
		Thread myThread2 = new Thread( new MyThread("Abhishek"));
		myThread1.start();
		myThread2.start();
	}
}
