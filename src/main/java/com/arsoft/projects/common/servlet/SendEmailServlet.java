package com.arsoft.projects.common.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class SendEmailServlet  extends HttpServlet {

	private static final long serialVersionUID = 6504618863196061212L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StringBuilder sb = new StringBuilder();
	        BufferedReader br = request.getReader();
	        String str = null;
	        while ((str = br.readLine()) != null) {
	            sb.append(str);
	        }
	        
	        JSONObject jObj = new JSONObject(sb.toString());
			String order = jObj.getString("list");
			System.out.println(order);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
