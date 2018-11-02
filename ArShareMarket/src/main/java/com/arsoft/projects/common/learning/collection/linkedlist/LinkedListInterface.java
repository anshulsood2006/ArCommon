package com.arsoft.projects.common.learning.collection.linkedlist;

/**
 * <ol>
 * <li>It consists of multiple nodes in linear fashion but not stored at
 * contiguous memory location.</li>
 * <li>Each node contains a data field and a reference to the next node in the
 * list.</li>
 * <li>The first node is called head node</li>
 * <li>To access a particular node, we need to start from the head only. There
 * is no random access as in the case of array.</li>
 * <li></li>
 * <li></li>
 * <li></li>
 * <ol>
 * 
 * @param <LinkedListInterface>
 */
public interface LinkedListInterface {
	
	public int getSize();

	public Node getHead();

	public Node getNode(Object data);

	public Node getNodeFromHead(int position);

	public Node getNodeFromEnd(int position);

	public Node getMiddleNode();

	public Node getOccurenceCount(Object data);

	public void deleteList();

	public boolean contains(Object data);

	public boolean hasLoop();

	public int lengthOfLoop();

	public boolean isPalindrome();

	public void removeDuplicates();

	public void swapNodes(Node node1, Node node2);

	public LinkedListInterface reverse();

	public void printList();

	public void insertAtHead(Object data);

	public void insertBefore(Node node, Object data);

	public void insertAfter(Node node, Object data);

	public void insertAtEnd(Object data);

	public void deleteAtHead();

	public void deleteBefore(Node node);

	public void deleteAfter(Node node);

	public void deleteAtEnd();
}
