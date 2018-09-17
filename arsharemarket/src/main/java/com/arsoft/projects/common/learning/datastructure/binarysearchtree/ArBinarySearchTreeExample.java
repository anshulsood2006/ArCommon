package com.arsoft.projects.common.learning.datastructure.binarysearchtree;

//12, 4, 5, 6, 1, 34, 5, 4, 3, 2, 1, 4, 6, 7, 8, 8, 3, 4, 5, 6, 12, 87, 24
public class ArBinarySearchTreeExample {
	public static void main(String[] args) {
		ArBinarySearchTree tree = new ArBinarySearchTree(null);
		tree.insert(12);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(1);
		tree.insert(34);
		tree.insert(5);
		tree.insert(4);
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		tree.insert(4);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(12);
		tree.insert(87);
		tree.insert(24);
		tree.insert(12);
		tree.insert(12);
		tree.insert(12);
		tree.insert(12);
		tree.insert(12);
	}
}
