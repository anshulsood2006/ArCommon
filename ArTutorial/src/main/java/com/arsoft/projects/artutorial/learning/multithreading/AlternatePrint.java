package com.arsoft.projects.artutorial.learning.multithreading;

public class AlternatePrint {
	
	class MyThreadOne implements Runnable{
		private ArLock arLock;
		public MyThreadOne(ArLock arLock) {
			this.arLock = arLock;
		}

		@Override
		public void run() {
			for (int i = 0; i <10; i++){
				synchronized(this.arLock){
					if (this.arLock.flag == 1){
						System.out.println("1");
						this.arLock.flag = 2;
						try {
							arLock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					arLock.notify();
				}
			}
		}
		
	}
	
	
	class MyThreadTwo implements Runnable{
		private ArLock arLock;
		public MyThreadTwo(ArLock arLock) {
			this.arLock = arLock;
		}

		@Override
		public void run() {
			for (int i = 0; i <10; i++){
				synchronized(this.arLock){
					if (this.arLock.flag == 2){
						System.out.println("2");
						this.arLock.flag = 3;
						arLock.notify();
					}
					try {
						arLock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}			
		}
	}
	
	class MyThreadThree implements Runnable{
		private ArLock arLock;
		public MyThreadThree(ArLock arLock) {
			this.arLock = arLock;
		}

		@Override
		public void run() {
			for (int i = 0; i <10; i++){
				synchronized(this.arLock){
					if (this.arLock.flag == 3){
						System.out.println("3");
						this.arLock.flag = 1;
						arLock.notify();
					}
					try {
						arLock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}			
		}
	}
	
	public static void main(String[] args) {
		AlternatePrint ap = new AlternatePrint();
		ArLock arLock = new ArLock();
		Thread t1 = new Thread (ap.new MyThreadOne(arLock));
		Thread t2 = new Thread (ap.new MyThreadTwo(arLock));
		Thread t3 = new Thread (ap.new MyThreadThree(arLock));
		t1.start();
		t2.start();
		t3.start();
	}
}