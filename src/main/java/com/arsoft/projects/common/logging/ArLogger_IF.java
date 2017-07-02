package com.arsoft.projects.common.logging;

public interface ArLogger_IF {
	
	//This method returns the logger associated with a class
	public ArLogger getClassLogger(Class<?> clazz);
	
	//This methods logs the message of type info
	public void logInfo(String infoMesasge);
}