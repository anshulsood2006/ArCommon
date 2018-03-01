package com.arsoft.projects.common.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.arsoft.projects.common.email.ArEmailUtil;
import com.arsoft.projects.common.properties.ArPropertyHandler;
import com.arsoft.projects.dukaan.ArDukaanUtil;

public class ArEmailSenderServlet  extends HttpServlet {

	private static final long serialVersionUID = 6504618863196061212L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StringBuilder sb = new StringBuilder();
	        BufferedReader br = request.getReader();
	        String str = null;
	        while ((str = br.readLine()) != null) {
	            sb.append(str);
	        }
	        JSONObject jsonObject = new JSONObject(sb.toString());
			JSONArray jsonArray = jsonObject.getJSONArray("orderList");
			JSONObject jsonobject = jsonArray.getJSONObject(0);
			String name = (String)jsonobject.get("name");
			String address = (String) jsonobject.get("address");
			String phone = (String)jsonobject.get("phone");
			String email = (String)jsonobject.get("email");
			String order = (String)jsonobject.get("order");
			String subject = "Order received from "+name;
			String from = ArPropertyHandler.getProperty("dukaan.name");
			String messageBody = "Hello!! \n\nNew order received from: "+name+" ("+phone+").\n\nThe order needs to be "
					+ "delivered at below address:\n\n"+address +"\n\nOrder is:\n\n"+order+ "\n\nClient can be contacted via E-MAIL at: "+email;
			ArEmailUtil.sendEmail(subject, from, messageBody, ArDukaanUtil.getDefaultOrderReceivers());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
