package com.arsoft.projects.artutorial.learning.multithreading;

//The object on which monitor will be obtained
public class ArMessage {
	
	private String message;
	
	public ArMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
