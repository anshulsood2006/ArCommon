package com.arsoft.projects.common.webservice;

import org.junit.Test;

import com.arsoft.projects.common.equity.ArEquityAction;
import com.arsoft.projects.common.equity.ArEquityHelper;
import com.arsoft.projects.common.equity.ArEquityTransaction;

public class ArWebServiceTest {
	/*@Test
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
		String[] asset = {"RPOWER","JSWENERGY","COALINDIA","NATIONALUM","IDEA","ASHOKLEY","NMDC","BHEL","PFC","DIVISLAB","JINDALSTEL","GMRINFRA","TATAPOWER","NETWORK18","HATHWAY","SAIL","IFCI","VIDEOIND","HINDCOMPOS","IDFC","SINTEX","TATASTEEL","ITC","SCHAND","TATAPOWER","IBVENTURES","VAKRANGEE"}; 
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
		System.out.println("#############################################################");
		for (Map.Entry<String, String> entryMap: map.entrySet()){
			System.out.println(entryMap.getKey()+"="+entryMap.getValue());
		}
	}*/
	
	@Test
	public void getStockBuyPrice(){
		ArEquityTransaction arEquityTransaction = ArEquityHelper.getArEquityTransaction(34.00f, ArEquityAction.BUY);
		System.out.println(arEquityTransaction);
	}
	
	@Test
	public void getStockSellPrice(){
		ArEquityTransaction arEquityTransaction = ArEquityHelper.getArEquityTransaction(125f, ArEquityAction.SELL);
		System.out.println(arEquityTransaction);
	}
	
	@Test
	public void getStockPricePrfit(){
		ArEquityTransaction arEquityTransaction = ArEquityHelper.getArEquityTransactionForProfit(1595F, 5f);
		System.out.println(arEquityTransaction);
	}
	
				
}
