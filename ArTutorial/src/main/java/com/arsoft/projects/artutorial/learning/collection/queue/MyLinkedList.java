package com.arsoft.projects.artutorial.learning.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyLinkedList {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= 20; i++){
			if (i == 1 ){
				System.out.println("Queue.add(): ");
			}
			q.add(i);
		}
		System.out.println("Queue.add() can be used to add null object ");
		q.add(null);
		System.out.println("Size of queue: "+q.size());
		System.out.println("Queue.peek() returns but does not remove the element from the queue: "+q.peek());
		System.out.println("Queue.peek() returns but does not remove the element from the queue: "+q.peek());
		System.out.println("Queue.element() returns but does not remove the element from the queue: "+q.element());
		System.out.println("Queue.element() returns but does not remove the element from the queue: "+q.element());
		System.out.println("Queue.poll() returns and removes the element from the queue: "+q.poll());
		System.out.println("Queue.poll() returns and removes the element from the queue: "+q.poll());
		System.out.println("Queue.remove() returns and removes the element from the queue: "+q.remove());
		System.out.println("Queue.remove() returns and removes the element from the queue: "+q.remove());
	}
}
