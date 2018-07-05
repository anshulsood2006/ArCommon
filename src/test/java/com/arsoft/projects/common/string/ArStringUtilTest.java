package com.arsoft.projects.common.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
	
	@Test
	public void testSplitString() {
		String[] ary = ArStringUtil.splitString(null, "");
		assertNull(ary);
		ary = ArStringUtil.splitString(null, null);
		assertNull(ary);
		ary = ArStringUtil.splitString("abc", null);
		assertNotNull(ary);
		assertEquals(3, ary.length);
		ary = ArStringUtil.splitString("SBIN||SBIN_Current_Data_05_07_2018||Current Data||05_07_2018@12_08_56||05_07_2018@14_22_33", null);
		assertEquals(90, ary.length);
		ary = ArStringUtil.splitString("SBIN||SBIN_Current_Data_05_07_2018||Current Data||05_07_2018@12_08_56||05_07_2018@14_22_33", "||");
		assertEquals(5, ary.length);
	}
}
