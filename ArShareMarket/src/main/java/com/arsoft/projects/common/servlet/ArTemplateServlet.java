package com.arsoft.projects.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArTemplateServlet extends HttpServlet {

	private final static Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());

	private static final long serialVersionUID = 2140876001035372352L;

	public void init() throws ServletException {
		logger.debug("Inside init() method");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Inside doGet() method");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("Inside doPost() method");
	}

	public void destroy() {
		logger.debug("Inside destroy() method");
	}

}
