package com.arsoft.projects.common.learning.multithreading;

//Thread t1, t1 and t3 are printing A, B and C continuously. Make them to print in this manner: ABCABCABCABCABCABCABC and so on
public class ArThreadSynchronizedExample implements Runnable{

	/*
	 * A lock object is created which has flag set to 1
	 * T1 starts and writes A inside synchronized block. The flag is then set to 2
	 * 
	 */
	private char toPrint;
	
	private ArLock lock;
	
	public ArThreadSynchronizedExample(char toPrint){
		this.toPrint = toPrint;
	}
	
	@Override
	public void run() {
		synchronized(lock) {
		while (lock.flag == 1)
			for (int i = 0; i < 20; i++){
				System.out.print(this.toPrint);	
				lock.flag = 2;
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread (new ArThreadSynchronizedExample('A'));
		Thread t2 = new Thread (new ArThreadSynchronizedExample('B'));
		Thread t3 = new Thread (new ArThreadSynchronizedExample('C'));
		t1.start();
		t2.start();
		t3.start();
	}
}
