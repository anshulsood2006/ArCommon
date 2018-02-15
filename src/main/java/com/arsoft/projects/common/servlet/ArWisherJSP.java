package com.arsoft.projects.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArWisherJSP extends HttpServlet {

	private static final long serialVersionUID = 6504618863196061212L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String to = request.getParameter("person");
			to = (to == null) ? "": to;
			request.getRequestDispatcher("/WEB-INF/pages/wish.jsp").forward(request, response);;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
