package com.arsoft.projects.common.learning;

public class Ambiguous {
	public void method(String args){
		
	}
	
	public void method(int args){
		
	}
	
	public static void main(String[] args) {
		Ambiguous ambiguous = new Ambiguous();
		ambiguous.method(null);
		//System.out.println(null);
	}
}
