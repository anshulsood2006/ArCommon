package com.arsoft.projects.common.webservice;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;

import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.json.ArJsonUtil;
import com.arsoft.projects.common.webservice.ArHttpMethod;
import com.arsoft.projects.common.webservice.ArWebServiceUtil;

public class ArWebServiceTest {
	@Test
	public void excecuteWebService() throws MalformedURLException, ArException{
		String url = "http://finance.google.com/finance/info?q=NSE:RPOWER";
		Map<String, String> map = new HashMap<>();
		map.put("Accept", "application/json");
		String output = ArWebServiceUtil.excecute(url, ArHttpMethod.GET, map);
		assertNotNull(output);
	}
	
	@Test
	public void excecuteWebServiceNullMap() throws MalformedURLException, ArException{
		String url = "http://finance.google.com/finance/info?q=NSE:RPOWER";
		String output = ArWebServiceUtil.excecute(url, ArHttpMethod.GET, null);
		assertNotNull(output);
	}
	
	@Test
	public void excecuteWebServiceNullMethod() throws MalformedURLException, ArException{
		String url = "http://finance.google.com/finance/info?q=NSE:RPOWER";
		String output = ArWebServiceUtil.excecute(url, null, null);
		assertNotNull(output);
		assertEquals(1, ArJsonUtil.getListOfJsonObject(output).size());
	}
	
	@Test
	public void getValue() throws MalformedURLException, ArException{
		String str = "";
		String[] asset = {"RPOWER","JSWENERGY","COALINDIA","NATIONALUM","IDEA","ASHOKLEY","NMDC","BHEL","PFC","DIVISLAB","JINDALSTEL","GMRINFRA","TATAPOWER","NETWORK18","HATHWAY","SAIL","IFCI","VIDEOIND","HINDCOMPOS","IDFC","SINTEX","TATASTEEL","ITC","SCHAND","TATAPOWER","IBVENTURES"}; 
		List<String> assetList = Arrays.asList(asset); 
		Map<String, String> map = new LinkedHashMap<>();
		for (String myAsset: assetList){
			String url = "http://finance.google.com/finance/info?q=NSE:"+myAsset;
			String output = ArWebServiceUtil.excecute(url, null, null);
			assertNotNull(output);
			List<JSONObject> list = ArJsonUtil.getListOfJsonObject(output);
			for (JSONObject jsonObject:list){
				String value = ArJsonUtil.getValue(jsonObject, "l");
				map.put(myAsset, value);
				assertNotNull(value);
			}
		}
		for (Map.Entry<String, String> entryMap: map.entrySet()){
			System.out.println(entryMap.getValue());
		}
	}
	

			
}
