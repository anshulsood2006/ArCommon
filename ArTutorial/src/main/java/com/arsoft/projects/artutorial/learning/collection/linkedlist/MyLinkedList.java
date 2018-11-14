package com.arsoft.projects.artutorial.learning.collection.linkedlist;

public class MyLinkedList implements LinkedListInterface {
	
	private Node head;
	private int size;

	public MyLinkedList(){
		this.size = 0;
		this.head = null;
	}
	
	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public Node getHead() {
		return this.head;
	}

	@Override
	public Node getNode(Object data) {
		return null;
	}

	@Override
	public Node getNodeFromHead(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getNodeFromEnd(int position) {
		return null;
	}

	@Override
	public Node getMiddleNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getOccurenceCount(Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteList() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean contains(Object data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasLoop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lengthOfLoop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isPalindrome() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeDuplicates() {
		// TODO Auto-generated method stub
	}

	@Override
	public void swapNodes(Node node1, Node node2) {
		// TODO Auto-generated method stub
	}

	@Override
	public LinkedListInterface reverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printList() {
		int size = this.size;
		for (int i =0 ; i < size; i++){
			//Node node = t
		}
	}

	@Override
	public void insertAtHead(Object data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertBefore(Node node, Object data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertAfter(Node node, Object data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertAtEnd(Object data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAtHead() {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteBefore(Node node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAfter(Node node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAtEnd() {
		// TODO Auto-generated method stub
	}
}
