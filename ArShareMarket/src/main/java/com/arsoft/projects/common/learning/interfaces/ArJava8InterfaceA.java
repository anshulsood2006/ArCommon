package com.arsoft.projects.common.learning.interfaces;

public interface ArJava8InterfaceA {
	
	public void write(String text);
	
	default void log(String logText) {
		System.out.println("Logging: "+logText);
	}
}
