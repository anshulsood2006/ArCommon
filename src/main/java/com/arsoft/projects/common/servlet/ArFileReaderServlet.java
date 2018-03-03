package com.arsoft.projects.common.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsoft.projects.common.file.ArFileUtil;

public class ArFileReaderServlet extends HttpServlet {

	private final static Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());

	private static final long serialVersionUID = 2140876001035372352L;

	public void init() throws ServletException {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream inputStream = null;
		try {
			String path = request.getParameter("path");
			if (path == null) {
				throw new ServletException("Not able to find the key 'path' in request");
			}
			else {
				try {
					inputStream = new FileInputStream(path);
				}catch (FileNotFoundException e) {
					logger.debug("Not able to read using absolute path : "+path+ ". Will try relative path now.");
					inputStream = getServletContext().getResourceAsStream(path);
				}catch(SecurityException e) {
					logger.error("Security Exception occurred for file at path: "+path);
				}
			}
			if (inputStream == null) {
				logger.error("Unable to read file from path : "+path);
				response.getWriter().write("Unable to read file from path : "+path);
			}else {
				String content = ArFileUtil.getFileContentAsString(inputStream);
				response.getWriter().write(content);
			}
		}catch(Exception e) {
			logger.error("Exception occurred for file: "+e.getLocalizedMessage());
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void destroy() {
	}

}
