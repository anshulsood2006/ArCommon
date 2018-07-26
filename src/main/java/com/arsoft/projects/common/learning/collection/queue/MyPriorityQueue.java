package com.arsoft.projects.common.learning.collection.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyPriorityQueue {
	
	class Customer {
		
		private int id;
		private String name;
		
		public Customer(int i, String n){
			this.id=i;
			this.name=n;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
		
	}
	
	public static Comparator<Customer> idComparator = new Comparator<Customer>(){
		@Override
		public int compare(Customer c1, Customer c2) {
	        return (int) (c1.getId() - c2.getId());
		}
	};
		
	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(51);
		queue.add(1);
		queue.add(-1);
		queue.add(200);
		queue.add(187654);
		queue.add(12);
		queue.add(572);
		queue.add(511);
		queue.add(1251);
		queue.add(5321);
		queue.add(51211);
		queue.add(19651);
		System.out.println("Priority Queue: "+queue);
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		System.out.println("Polling from Priority Queue happens in the natural order: "+queue.poll());
		queue = new LinkedList<>();
		queue.add(51);
		queue.add(1);
		queue.add(-1);
		queue.add(200);
		queue.add(187654);
		queue.add(12);
		queue.add(572);
		queue.add(511);
		queue.add(1251);
		queue.add(5321);
		queue.add(51211);
		queue.add(19651);
		System.out.println("Priority Queue: "+queue);
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		System.out.println("Polling from Linked List Queue happens in FIFO order: "+queue.poll());
		Queue<Customer> customer = new PriorityQueue<>(10, idComparator);
	}
}
