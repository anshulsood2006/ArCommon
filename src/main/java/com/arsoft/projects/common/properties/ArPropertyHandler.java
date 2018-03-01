package com.arsoft.projects.common.properties;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsoft.projects.common.servlet.ArEnvironmentServlet;

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
	
	private static ArPropertyHandler arPropertyHandler;
	private static Properties arProperties;

	private ArPropertyHandler() throws IOException, ServletException {
		if (arProperties == null){
			arProperties = new Properties();
			arProperties.load(ArEnvironmentServlet.getPropertyFileAsInputStream());
		}
	}
	
	private static ArPropertyHandler loadProperties() throws IOException, ServletException{
		if (arPropertyHandler == null){
			synchronized(ArPropertyHandler.class){
				if(arPropertyHandler == null){
					arPropertyHandler = new ArPropertyHandler();
				}
			}
		}
		return arPropertyHandler;
	}
	
	public static String getProperty(String key) throws IOException, ServletException{
		loadProperties();
		logger.debug("Properties loaded successfully");
		return arProperties.getProperty(key);
	}
}
