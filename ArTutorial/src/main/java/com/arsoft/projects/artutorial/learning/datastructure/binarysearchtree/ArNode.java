package com.arsoft.projects.artutorial.learning.datastructure.binarysearchtree;
public class ArNode{
	
	private int value;
	private ArNode leftChild;
	private ArNode rightChild;
	
	public ArNode(ArNode leftChild, int value, ArNode rightChild){
		this.leftChild = leftChild;
		this.value = value;
		this.rightChild = rightChild;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public void setLeftChild(ArNode leftChild){
		this.leftChild = leftChild;
	}
	
	public void setRightChild(ArNode rightChild){
		this.rightChild = rightChild;
	}
	
	public int getValue(){
		return value;
	}
	
	public ArNode getLeftChild(){
		return this.leftChild;
	}
	
	public ArNode getRightChild(){
		return this.rightChild;
	}
}