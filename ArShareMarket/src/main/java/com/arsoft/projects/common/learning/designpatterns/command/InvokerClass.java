package com.arsoft.projects.common.learning.designpatterns.command;

public class InvokerClass {
	public String executeOperation(Operation command) {
        return command.execute();
    }
}
