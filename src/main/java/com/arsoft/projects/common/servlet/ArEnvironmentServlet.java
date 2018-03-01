package com.arsoft.projects.common.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArEnvironmentServlet extends HttpServlet  {

	private final static Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	private static final long serialVersionUID = 2140876001035372352L;
	
	public static InputStream inputStream = null;
	
	public static InputStream getPropertyFileAsInputStream() throws ServletException{
		if (inputStream == null){
			throw new ServletException("ArEnvironmentServlet::Not able to get the property file as input stream");
		}
		return inputStream;
	}
	
	public void init() throws ServletException{
		String configFileLocation = null;
		try{
			configFileLocation = System.getProperty("arcommon.config.file.location");
			if (configFileLocation == null){
				logger.error("ArEnvironmentServlet::No System property 'arcommon.config.file.location' defined. Getting the default location from web.xml file");
				configFileLocation= getServletContext().getInitParameter("arcommon.config.file.location");
			}else{
				logger.debug("ArEnvironmentServlet::System property 'arcommon.config.file.location' is: "+configFileLocation);
			}
			if(configFileLocation == null){
				throw new ServletException("ArEnvironmentServlet::Not able to get the location for config file");
			}else{
				inputStream = getServletContext().getResourceAsStream(configFileLocation);
				//Read from the file path in case the file from stream is not found
				if (inputStream == null){
					inputStream = new FileInputStream(configFileLocation);
				}
			}
			logger.debug("ArEnvironmentServlet::Input Stream initialized successfully");
		}catch(Exception exception){
			throw new ServletException("ArEnvironmentServlet::Exception occured inside ArEnvironmentServlet.doGet(): "+exception.getLocalizedMessage());
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	 public void destroy() {
		if (inputStream != null){
			try {
				inputStream.close();
			} catch (IOException e) {
				logger.error("ArEnvironmentServlet::IOException occured while closing input stream: "+e.getLocalizedMessage());
			}
		}
	 }
	
}
