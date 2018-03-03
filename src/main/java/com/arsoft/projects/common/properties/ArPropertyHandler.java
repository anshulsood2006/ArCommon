package com.arsoft.projects.common.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * This is a Singleton class to hold the properties values at server startup.
 * The singleton design will make sure that there is only one instance of this class inside JVM
 * The singleton can be created by:
 * 
 * 1. Declare the constructor private to avoid creation of objects of this class from outside
 * 2. Declare a private static variable of the same class which will be the only instance of this class.
 * 3. Create a public static method that return the above variable. This method is the global access point to get the instance of this class
 * 
 */
public class ArPropertyHandler {
	
	private final static Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	private static Properties arProperties;

	public static String getProperty(String key) throws IOException, ServletException{
		
		return arProperties.getProperty(key);
	}

	public static Properties loadProperties(InputStream stream) throws IOException {
		if (arProperties == null){
			synchronized(ArPropertyHandler.class){
				if(arProperties == null){
					arProperties = new Properties();
				}
			}
		}
		arProperties.load(stream);
		logger.debug("Properties loaded successfully");
		return arProperties;
	}
}
