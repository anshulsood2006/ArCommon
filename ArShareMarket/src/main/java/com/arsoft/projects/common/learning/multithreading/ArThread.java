package com.arsoft.projects.common.learning.multithreading;

public class ArThread extends Thread{
	
	private String name;
	
	public ArThread(String name){
		this.name = name;
	}
	
	@Override
	public void run(){
		System.out.println("Thread: "+this.name+" is finished.");
	}
	
}