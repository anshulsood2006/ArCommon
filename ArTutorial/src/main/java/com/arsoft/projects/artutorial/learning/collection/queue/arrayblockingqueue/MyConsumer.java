package com.arsoft.projects.artutorial.learning.collection.queue.arrayblockingqueue;

import java.util.concurrent.BlockingQueue;

public class MyConsumer implements Runnable{
	private BlockingQueue queue;
	
	public MyConsumer(BlockingQueue queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		while(queue.remainingCapacity() > 0){
			System.out.println("Queue size: "+queue.size() +", Remaining capacity: "+queue.remainingCapacity());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
