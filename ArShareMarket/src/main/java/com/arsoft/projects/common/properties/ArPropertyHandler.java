package com.arsoft.projects.common.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.string.ArStringUtil;

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
	
	private static Map<String, String> arPropertiesMap;

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
		@SuppressWarnings("unchecked")
		Enumeration<String> arPropertiesEnumeration = (Enumeration<String>) arProperties.propertyNames();
	    while (arPropertiesEnumeration.hasMoreElements()) {
	    	if (arPropertiesMap == null){
	    		arPropertiesMap = new HashMap<>();
	    	}
	    	String key = arPropertiesEnumeration.nextElement();
	    	String value = arProperties.getProperty(key);
	    	arPropertiesMap.put(key, value);
	    }
		logger.debug("Properties loaded successfully");
		return arProperties;
	}
	
	public static Map<String, String> getPropertyAsMap(String key) throws ArException {
		if (arProperties == null){
			throw new ArException("Properties not loaded in memory. Restart the webserver.");
		}
		if (ArStringUtil.isNullOrEmptyString(key)){
			logger.error("Null parameter passed as key to getPropertyAsMap method");
			return null;
		}
		if (key.equals("ALL")){
			return arPropertiesMap;
		}
		Map<String, String> arPropertiesMapForKey = new HashMap<>();
		arPropertiesMapForKey.put(key, arPropertiesMap.get(key));
		return arPropertiesMapForKey;
	}
}
