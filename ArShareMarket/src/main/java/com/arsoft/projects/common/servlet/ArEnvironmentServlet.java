package com.arsoft.projects.common.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsoft.projects.common.properties.ArPropertyHandler;

public class ArEnvironmentServlet extends HttpServlet  {

	private final static Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	private static final long serialVersionUID = 2140876001035372352L;
	
	public void init() throws ServletException{
		try {
			initializeProperties();
			initializeTables();
		}
		catch(ServletException exception) {
			throw new ServletException("Exception occurred inside ArEnvironmentServlet.init(): "+exception.getLocalizedMessage());
		}
		
		
	}
	
	private void initializeTables() {
		
	}

	private Properties initializeProperties() throws ServletException {
		String configFileLocation = null;
		InputStream stream = null;
		try{
			configFileLocation = getServletContext().getInitParameter("arcommon.config.file.location");
			if (configFileLocation == null){
				throw new ServletException("Not able to get the property arcommon.config.file.location");
			}
			else {
				stream = getServletContext().getResourceAsStream(configFileLocation);
				if (stream == null) {
					throw new ServletException("Not able to get the default config.properties file at the location");
				}else {
					ArPropertyHandler.loadProperties(stream);
					logger.debug("Properties read successfully from internal config file");
				}
			}
			configFileLocation = System.getProperty("arcommon.config.file.location");
			if (configFileLocation == null){
				logger.error("No System property 'arcommon.config.file.location' defined. Getting the properties only from default config.properties file");
			}else{
				try {
					stream = new FileInputStream(configFileLocation);
					ArPropertyHandler.loadProperties(stream);
					logger.debug("Properties read successfully from external config file at location: "+configFileLocation);
				}catch (FileNotFoundException e) {
					logger.error("No config.properties File found at location : "+configFileLocation);
				}catch(SecurityException e) {
					logger.error("Security Exception occurred for config.properties File found at location: "+configFileLocation);
				}
			}
		}catch(Exception exception){
			throw new ServletException("Exception occurred inside ArEnvironmentServlet.initializeProperties(): "+exception.getLocalizedMessage());
		}
		return null;
	} 
	
}
