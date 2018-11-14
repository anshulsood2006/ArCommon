package com.arsoft.projects.artutorial.learning.datastructure;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyFailFastQueues {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.add("Raja");
		queue.add("Mantri");
		queue.add("Chor");
		queue.add("Sipahi");
		queue.add("Ester");
		queue.add("Zombie");
		queue.add("Boss");
		System.out.println(queue);
		queue.clear();
		queue = new PriorityQueue<>();
		queue.add("Raja");
		queue.add("Mantri");
		queue.add("Chor");
		queue.add("Sipahi");
		queue.add("Ester");
		queue.add("Zombie");
		queue.add("Boss");
		System.out.println(queue);
		for (int i = 0; i < 7; i++){
			System.out.println(queue.peek());
		}
	}
}
