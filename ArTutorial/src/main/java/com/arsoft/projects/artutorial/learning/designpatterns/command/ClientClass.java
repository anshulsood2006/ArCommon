package com.arsoft.projects.artutorial.learning.designpatterns.command;

public class ClientClass{
	public static void main(String[] args) {
		InvokerClass invokerClass = new InvokerClass();
		invokerClass.executeOperation(new OpenOperationCommandClass(new ReceiverClass("file1.txt")));
		invokerClass.executeOperation(new CloseOperationCommandClass(new ReceiverClass("file2.txt")));
	}
}