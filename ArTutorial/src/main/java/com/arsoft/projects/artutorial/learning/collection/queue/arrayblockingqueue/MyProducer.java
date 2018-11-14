package com.arsoft.projects.artutorial.learning.collection.queue.arrayblockingqueue;

import java.util.concurrent.BlockingQueue;

public class MyProducer implements Runnable{
	private BlockingQueue queue;
	
	public MyProducer(BlockingQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <8; i++){	
			System.out.println("Trying to add to the queue: "+ i +" and the result was "+queue.offer(i));
			try{
				Thread.sleep(500);
			}catch(InterruptedException  e){
				e.printStackTrace();
			}
		}
	}
}
