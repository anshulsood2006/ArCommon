package com.arsoft.projects.common.learning.designpatterns.command;

public class OpenOperationCommandClass implements Operation{

	private ReceiverClass receiverClass;
	
	public OpenOperationCommandClass(ReceiverClass receiverClass) {
		this.receiverClass = receiverClass;
	}
	@Override
	public String execute(){
		return receiverClass.openFile();
	}
	
}
