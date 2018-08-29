package com.arsoft.projects.common.learning.designpatterns.command;

public class CloseOperationCommandClass implements Operation {
	
	private ReceiverClass receiverClass;
	
	public CloseOperationCommandClass(ReceiverClass receiverClass) {
		this.receiverClass = receiverClass;
	}
	@Override
	public String execute(){
		return receiverClass.closeFile();
	}
}
