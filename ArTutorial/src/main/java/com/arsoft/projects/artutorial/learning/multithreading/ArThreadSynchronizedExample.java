package com.arsoft.projects.artutorial.learning.multithreading;

//Thread t1, t1 and t3 are printing A, B and C continuously. Make them to print in this manner: ABCABCABCABCABCABCABC and so on
public class ArThreadSynchronizedExample{

	public static void main(String[] args) {
		ArLock lock = new ArLock();
		Thread t1 = new Thread (new ArThreadA(lock));
		Thread t2 = new Thread (new ArThreadB(lock));
		Thread t3 = new Thread (new ArThreadC(lock));
		t1.start();
		t2.start();
		t3.start();
	}
}
