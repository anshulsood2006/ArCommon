package com.arsoft.projects.artutorial.learning.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArDemoServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -976499313193346497L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	    PrintWriter out = resp.getWriter();
		ServletContext ctx = getServletContext();
		out.println("ServletContext is: "+ctx);
		Enumeration<String> params = ctx.getInitParameterNames();
		while (params.hasMoreElements()){
			String name = params.nextElement();
			out.println("Application Init Param '"+name+"' = "+ctx.getInitParameter(name));
		}
		
		ServletConfig config = getServletConfig();
		params = config.getInitParameterNames();
		while (params.hasMoreElements()){
			String name = params.nextElement();
			out.println("Servlet Init Param '"+name+"' = "+config.getInitParameter(name));
		}
	}
}
