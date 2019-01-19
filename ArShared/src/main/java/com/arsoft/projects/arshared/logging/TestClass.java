package com.arsoft.projects.arshared.logging;

public class TestClass {
	
	public static void main(String[] args) {
		try{
			System.out.println("try");
			throw new Exception("Anshul Sood");
		}catch(Exception e){
			System.out.println("Here");
		}
	}
	
}
