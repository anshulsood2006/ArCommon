package com.arsoft.projects.common.learning.multithreading;
	
	public class MyHandwrittenTest{
		
		private Object lock = new Object();
	
		class MyRunnableHandwritten implements Runnable{
			private String message;
			public MyRunnableHandwritten(String message) {
				this.message = message;
			}
			public void run(){
				for (int i = 0; i <20; i++) {
					synchronized(lock) {
						System.out.println(message);
					}
				}
			}
		}
		
		public static void main(String[] args){
			MyHandwrittenTest test = new MyHandwrittenTest();
			Thread t1 = new Thread(test.new MyRunnableHandwritten("Anshul"));
			Thread t2 = new Thread(test.new MyRunnableHandwritten("Akhil"));
			Thread t3 = new Thread(test.new MyRunnableHandwritten("Abhishek"));
			t1.start();
			t2.start();
			t3.start();
		}
	}

