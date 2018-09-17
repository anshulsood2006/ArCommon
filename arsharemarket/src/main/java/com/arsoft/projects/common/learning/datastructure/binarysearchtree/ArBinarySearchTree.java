package com.arsoft.projects.common.learning.datastructure.binarysearchtree;

/**
	*if root node is null
		Add the given node as root node.
		exit
	else if root node is not null
		Get the value of root node as parent node
		if value of new node is less than or equal to the value of parent node (Step 1)
			The new node needs to be added as left child
			If the parent node already has left child
				Make left child as parent node and go to step 1
			else if the parent node has no left child
				Add the node as child node
		else if value of new node is greater than the value of parent node
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
			if (parentNodeLeftChild != null){
				setElement(parentNodeRightChild, value);
			}else{
				parentNode.setRightChild(new ArNode(null, value, null));
			}
		}
	}
	
}