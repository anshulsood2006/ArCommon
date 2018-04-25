package com.arsoft.projects.common.learning.multithreading;

public class ArThreadA implements Runnable{
	
	private ArLock lock;
	private char charToPrint = 'A';
	
	public ArThreadA(ArLock lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		try {
			synchronized(lock){	
				for (int i = 0; i < 15; i ++){
					while(lock.flag != 1){
						lock.wait();
					}
					System.out.print(charToPrint);
					lock.flag = 2;
					lock.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
