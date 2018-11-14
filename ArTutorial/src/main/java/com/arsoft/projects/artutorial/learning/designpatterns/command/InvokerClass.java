package com.arsoft.projects.artutorial.learning.designpatterns.command;

public class InvokerClass {
	public String executeOperation(Operation command) {
        return command.execute();
    }
}
