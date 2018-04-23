package com.arsoft.projects.common.learning.interfaces;

public interface ArJava8Interface {
	
	public void write(String text);
	
	default void log(String logText) {
		System.out.println("Logging: "+logText);
	}
}
