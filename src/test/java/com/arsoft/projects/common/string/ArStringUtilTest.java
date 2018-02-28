package com.arsoft.projects.common.string;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class ArStringUtilTest {
 
	@Test
	public void testJson(){
		StringBuilder sb = new StringBuilder("{\"list\":[{\"name\":\"a\",\"email\":\"sa@as.com\",\"phone\":\"as\",\"address\":\"as\",\"order\":\"as\"}]}");
		JSONObject jsonObject = new JSONObject(sb.toString());
		JSONArray jsonArray = jsonObject.getJSONArray("list");
		JSONObject jsonobject = jsonArray.getJSONObject(0);
		String name = (String)jsonobject.get("name");
		String address = (String) jsonobject.get("address");
		String phone = (String)jsonobject.get("phone");
		String email = (String)jsonobject.get("email");
		String order = (String)jsonobject.get("order");
		Map<String, String> orderList = new HashMap<>();
		orderList.put("NAME", name);
		orderList.put("PHONE", phone);
		orderList.put("EMAIL", email);
		orderList.put("ADDRESS", address);
		orderList.put("ORDER", order);
		System.out.println(orderList);
	}
}
