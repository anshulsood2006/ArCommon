package com.arsoft.projects.artutorial.learning.collection.linkedlist;

/**
 * Each node of a linked list contains a data field and a reference(link) to the
 * next node in the list
 */
public class Node {

	private Object data;
	private Node next;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "data: " + this.data + " next: " + this.next;
	}
}