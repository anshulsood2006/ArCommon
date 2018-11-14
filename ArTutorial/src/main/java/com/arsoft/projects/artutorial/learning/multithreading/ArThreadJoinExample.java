package com.arsoft.projects.artutorial.learning.multithreading;

public class ArThreadJoinExample {
	public static void main(String[] args) {
		System.out.println("######################################### Main thread finished last #####################################################");
		finishMainLast();
		System.out.println("######################################### Order is t1, t2, t3, t4 and then main #########################################");
		finishThreadsInLine();
		System.out.println("######################################### Undeterministic order #########################################################");
		finishInInorderedWay();
	}
	
	//This method makes the thread to be called and completed in un-deterministic way 
	private static void finishInInorderedWay() {
		ArThread t1 = new ArThread("T1 inside finishInInorderedWay");
		ArThread t2 = new ArThread("T2 inside finishInInorderedWay");
		ArThread t3 = new ArThread("T3 inside finishInInorderedWay");
		ArThread t4 = new ArThread("T4 inside finishInInorderedWay");
		try {
			t1.start();
			t2.start();
			t3.start();
			t4.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Main thread is finished inside finishInInorderedWay");
	}

	//This method makes the thread to be completed in deterministic way. Here the order of completion of threads would be t1, t2, t3, t4 and main 
	private static void finishThreadsInLine() {
		ArThread t1 = new ArThread("T1 inside finishThreadsInLine");
		ArThread t2 = new ArThread("T2 inside finishThreadsInLine");
		ArThread t3 = new ArThread("T3 inside finishThreadsInLine");
		ArThread t4 = new ArThread("T4 inside finishThreadsInLine");
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
			t3.join();
			t4.start();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
       
		System.out.println("Main thread is finished inside finishThreadsInLine");
		
	}

	//This method makes the main thread to be completed in deterministic way. The main thread will be the last to finish but other threads viz. t1, t2, t3 and t4 will still finish in undeterministic way.
	public static void finishMainLast(){
		ArThread t1 = new ArThread("T1 inside finishMainLast");
		ArThread t2 = new ArThread("T2 inside finishMainLast");
		ArThread t3 = new ArThread("T3 inside finishMainLast");
		ArThread t4 = new ArThread("T4 inside finishMainLast");
		try {
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
       
		System.out.println("Main thread is finished inside finishMainLast");
	}
}
