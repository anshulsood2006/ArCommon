package com.arsoft.projects.artutorial.learning.datastructure.binarysearchtree;

import java.util.Stack;

/**
	if root node is null
		Add the given node as root node.
		exit
	else if root node is not null
		Get the value of root node as parent node
		if value of new node is less than the value of parent node (Step 1)
			The new node needs to be added as left child
			If the parent node already has left child
				Make left child as parent node and go to step 1
			else if the parent node has no left child
				Add the node as child node
		else if value of new node is greater than or equal to the value of parent node
			The new node needs to be added as right child
			If the parent node already has right child
				Make right child as parent node and go to step 1
			else if the parent node has no right child
				Add the node as child nodes
**/
public class ArBinarySearchTree{
	private ArNode rootNode;
	
	public ArBinarySearchTree(ArNode rootNode){
		this.rootNode = rootNode;
	}
	
	public ArNode getRootNode(){
		return this.rootNode;
	}
	
	public void insert(int value){
		if (this.rootNode == null){
			this.rootNode = new ArNode(null, value, null);
		}
		else{
			ArNode parentNode = this.rootNode;
			setElement(parentNode, value);
		}
	}
	
	public void setElement(ArNode parentNode, int value){
		int parentNodeValue = parentNode.getValue();
		ArNode parentNodeLeftChild = parentNode.getLeftChild();
		ArNode parentNodeRightChild = parentNode.getRightChild();
		if (value <= parentNodeValue){
			if (parentNodeLeftChild != null){
				setElement(parentNodeLeftChild, value);
			}else{
				parentNode.setLeftChild(new ArNode(null, value, null));
			}
		}else{
			if (parentNodeRightChild != null){
				setElement(parentNodeRightChild, value);
			}else{
				parentNode.setRightChild(new ArNode(null, value, null));
			}
		}
	}
	
	public void inOrderTraversal(){
		ArNode rootNode = this.getRootNode();
		Stack<ArNode> stack = new Stack<>();
		ArNode parentNode = rootNode;
		stack.push(parentNode);
		while (!stack.isEmpty() || parentNode != null){
			traverse(parentNode, stack);
		}
	}
	
/**

	If parent element has left child  (Step 1)
		Get the left child as parent element. Go to step 1.
	If parent element has no left child
		If the parent element has right child
			Get the right child as parent element. Go to step 1.
		If the parent element has no right child
			Print the value of parent node
 * @param parentNode
 * @param stack 
 */
	private void traverse(ArNode parentNode, Stack<ArNode> stack) {
		stack.push(parentNode);
		if (parentNode.getLeftChild() != null){
			parentNode = parentNode.getLeftChild();
			traverse(parentNode, stack);
		}else if(parentNode.getLeftChild() == null){
			System.out.print(parentNode.getValue()+", ");
			if (parentNode.getRightChild() != null){
				parentNode = parentNode.getRightChild();
				traverse(parentNode, stack);
			}
			else if (parentNode.getRightChild() == null){
				System.out.print(parentNode.getValue()+", ");
			}
			stack.pop();
		}
	}
	
}