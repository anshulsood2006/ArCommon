package com.arsoft.projects.common.logging;

public class ArLoggingUtil{

	public static ArLogger getLogger(Class<?> enclosingClass) {
		System.out.println("Class is "+enclosingClass);
		return new ArLogger().getClassLogger(enclosingClass);
	}


	
}
