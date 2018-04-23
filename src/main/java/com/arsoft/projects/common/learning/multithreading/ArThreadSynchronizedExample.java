package com.arsoft.projects.common.learning.multithreading;

//Thread t1, t1 and t3 are printing A, B and C continuously. Make them to print in this manner: ABCABCABCABCABCABCABC and so on
public class ArThreadSynchronizedExample implements Runnable{

	private char toPrint;
	
	public ArThreadSynchronizedExample(char toPrint){
		this.toPrint = toPrint;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++){
			System.out.print(this.toPrint);	
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
