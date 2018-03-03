package com.arsoft.projects.common.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsoft.projects.common.properties.ArPropertyHandler;

public class ArEnvironmentServlet extends HttpServlet  {

	private final static Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	private static final long serialVersionUID = 2140876001035372352L;
	
	private static Properties arProperties;
	
	public void init() throws ServletException{
		String configFileLocation = null;
		InputStream stream = null;
		try{
			configFileLocation = getServletContext().getInitParameter("arcommon.config.file.location");
			if (configFileLocation == null){
				throw new ServletException("ArEnvironmentServlet::Not able to get the property arcommon.config.file.location");
			}
			else {
				stream = getServletContext().getResourceAsStream(configFileLocation);
				if (stream == null) {
					throw new ServletException("ArEnvironmentServlet::Not able to get the default config.properties file at the location");
				}else {
					arProperties = ArPropertyHandler.loadProperties(stream);
					logger.debug("ArEnvironmentServlet::Properties read successfully from internal config file");
				}
			}
			configFileLocation = System.getProperty("arcommon.config.file.location");
			if (configFileLocation == null){
				logger.error("ArEnvironmentServlet::No System property 'arcommon.config.file.location' defined. Getting the properties only from default config.properties file");
			}else{
				try {
					stream = new FileInputStream(configFileLocation);
					arProperties = ArPropertyHandler.loadProperties(stream);
					logger.debug("ArEnvironmentServlet::Properties read successfully from external config file at location: "+configFileLocation);
				}catch (FileNotFoundException e) {
					logger.error("ArEnvironmentServlet::No config.properties File found at location : "+configFileLocation);
				}catch(SecurityException e) {
					logger.error("ArEnvironmentServlet::Security Exception occurred for config.properties File found at location: "+configFileLocation);
				}
			}
		}catch(Exception exception){
			throw new ServletException("ArEnvironmentServlet::Exception occurred inside ArEnvironmentServlet.doGet(): "+exception.getLocalizedMessage());
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = null;
		String value = null;
		try {
			key = request.getParameter("key");
			if (key == null) {
				response.getWriter().write("Key is null");
			}
			if(key.equals("ALL")){
				Enumeration<?> e = arProperties.propertyNames();
			    while (e.hasMoreElements()) {
			      key = (String) e.nextElement();
			      response.getWriter().write(key + " -- " + arProperties.getProperty(key));
			      response.getWriter().write("\n");
			    }
			}
			else {
				value = arProperties.getProperty(key);
				response.getWriter().write("Value for key: "+key+" is: "+value);
			}
			
		}catch(Exception e){
			response.getWriter().write(e.getLocalizedMessage());
		}
	}
	
	 public void destroy() {
		 arProperties.clear();
	 }
	
}
