package com.arsoft.projects.artutorial.learning.standalone.multithreading.staticexamples;

public class MyThread implements Runnable{

	private String name;
	
	MyThread(String name){
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println("Thread "+ name +" is running.");
		
	}

	public String getName() {
		return this.name;
	}
}
