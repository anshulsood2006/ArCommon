package com.arsoft.projects.common.learning.multithreading;

public class MyRunnable implements Runnable{

	private String name;
	
	public MyRunnable( String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println("Running thread "+this.name);
	}
}
