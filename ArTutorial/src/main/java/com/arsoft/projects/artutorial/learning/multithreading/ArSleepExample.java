package com.arsoft.projects.artutorial.learning.multithreading;

public class ArSleepExample implements Runnable{
	
	private String name;
	
	public ArSleepExample(String name){
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Thread: "+name +" is waiting for 5000 milseconds");	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new ArSleepExample("Anshul"));
		Thread t2 = new Thread (new ArSleepExample("Akhil"));
		t1.start();
		t2.start();
	}
}
