package com.arsoft.projects.artutorial.learning.interfaces;

public interface ArJava8Interface {
	
	public void write(String text);
	
	default void log(String logText) {
		System.out.println("Logging: "+logText);
	}
}
