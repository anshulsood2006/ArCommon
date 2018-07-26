package com.arsoft.projects.common.learning.collection.queue.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyArrayBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
		Thread producer = new Thread(new MyProducer(queue));
		Thread consumer = new Thread(new MyConsumer(queue));
		producer.start();
		consumer.start();
	}
}
