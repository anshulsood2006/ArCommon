package com.arsoft.projects.common.learning.multithreading;

//The class that will be waiting for other threads to invoke notify method
public class ArWaiter implements Runnable {

	private ArMessage arMessage;
	
	public ArWaiter(ArMessage arMessage) {
		this.arMessage = arMessage;
	}
	
	@Override
	public void run() {
		synchronized (arMessage) {
			try {
				System.out.println("ArWaiter is waiting.");
				arMessage.wait();
			}catch(InterruptedException ex) {
				System.out.println("InterruptedException is thrown inside ArNotifier.");
			}
			System.out.println("ArWaiter is notified and "+arMessage.getMessage()+" is received successfully.");
		}
	}

}
