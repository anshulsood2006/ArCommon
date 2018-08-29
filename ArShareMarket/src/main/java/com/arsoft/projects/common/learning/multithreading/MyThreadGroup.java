package com.arsoft.projects.common.learning.multithreading;

public class MyThreadGroup{

	class ShutDownHook extends Thread{

		@Override
		public void run() {
			System.out.println("Shutdown hook is called");			
		}
		
	}

	public static void main(String[] args) {
		MyThreadGroup test = new MyThreadGroup();
		Runtime runtime = Runtime.getRuntime(); 
		runtime.addShutdownHook(test.new ShutDownHook());
		int i = 0;
		System.exit(1);
		while (true) {
			i ++;
			System.out.println("Incrementing");
			if (i == 1000000) {
				System.out.println("i == 100");
				System.exit(0);
			}
		}
	}

}