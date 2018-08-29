package com.arsoft.projects.common.learning.multithreading;

public class ArThreadB implements Runnable{
	
	private ArLock lock;
	private char charToPrint = 'B';
	
	public ArThreadB(ArLock lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		try {
			synchronized(lock){	
				for (int i = 0; i < 15; i ++){
					while(lock.flag != 2){
						lock.wait();
					}
					System.out.print(charToPrint);
					lock.flag = 3;
					lock.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
