package com.arsoft.projects.common.learning.designpatterns.command;

public class ReceiverClass {
	
	private String fileName;
	public ReceiverClass(String fileName) {
		this.fileName = fileName;
	}
	
	public String openFile() {
		return "Opening file "+fileName;
	}
	
	public String closeFile() {
		return "Closing file "+fileName;
	}
}
