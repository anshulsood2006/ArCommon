package com.arsoft.projects.artutorial.learning.multithreading;

public class ArThreadC implements Runnable{
	
	private ArLock lock;
	private char charToPrint = 'C';
	
	public ArThreadC(ArLock lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		try {
			synchronized(lock){	
				for (int i = 0; i < 15; i ++){
					while(lock.flag != 3){
						lock.wait();
					}
					System.out.print(charToPrint);
					lock.flag = 1;
					lock.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
