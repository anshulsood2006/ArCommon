package com.arsoft.projects.common.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArWisher extends HttpServlet {

	private static final long serialVersionUID = 6504618863196061212L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String to = request.getParameter("to");
		String event = request.getParameter("event");
		response.setContentType("text/html");// setting the content type
		PrintWriter pw = response.getWriter();// get the stream to write the	
		pw.println(to+" wishes you and your family \""+event+"\"");		
		URL u = new URL("http://localhost:8080/index.html");
		InputStream ins = u.openStream();
		try {
			if (ins != null) {
				InputStreamReader isr = new InputStreamReader(ins);
				BufferedReader reader = new BufferedReader(isr);
				int n = 0;
				String word = "";
				while ((word = reader.readLine()) != null) {
					pw.println(word);
				}
			}
		} finally {
			pw.close();
		}
	}
}
