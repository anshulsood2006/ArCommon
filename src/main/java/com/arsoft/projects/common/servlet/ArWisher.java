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

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String to = request.getParameter("from");
			response.setContentType("text/html");// setting the content type
			PrintWriter pw = response.getWriter();// get the stream to write the	
			URL u = new URL("http://myfriendwa.com/wish.html");
			InputStream ins = u.openStream();
			try {
				if (ins != null) {
					InputStreamReader isr = new InputStreamReader(ins);
					BufferedReader reader = new BufferedReader(isr);
					String word = "";
					while ((word = reader.readLine()) != null) {
						if (word.indexOf("$$") > 1) {
							word = word.replace("$$", to+" wishes you and your family");
						}
						pw.println(word);
					}
				}
			pw.write("<center><a href=\"whatsapp://send?text=\" onClick=\"sendViaWatsapp(); return false;\" class=\"button\">Share via watsapp</a></center>");
			} finally {
				pw.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
