package com.arsoft.projects.common.learning.multithreading;

public class ArDaemonThread implements Runnable{

	@Override
	public void run() {
		System.out.println("This is a daemon thread running.");
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new ArDaemonThread());
		t.setDaemon(true);
		t.start();
	}

}
