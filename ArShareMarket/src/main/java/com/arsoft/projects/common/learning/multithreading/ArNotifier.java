package com.arsoft.projects.common.learning.multithreading;

//The class that will notify one or all the waiting threads based on whether notify or notifyAll is called.
public class ArNotifier implements Runnable{

private ArMessage arMessage;
	
	public ArNotifier(ArMessage arMessage) {
		this.arMessage = arMessage;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			synchronized (arMessage) {
				System.out.println("ArNotifier is notifying.");
				arMessage.notifyAll();
				
            }
		}catch(InterruptedException ex) {
			System.out.println("InterruptedException is thrown inside ArNotifier.");
		}
	}

}
