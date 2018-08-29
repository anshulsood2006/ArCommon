package com.arsoft.projects.common.webservice.rest.sharemarket;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.json.JSONArray;
import org.json.JSONException;

import com.arsoft.projects.common.business.market.constant.ArScripConstant;
import com.arsoft.projects.common.business.market.entities.ArScrip;
import com.arsoft.projects.common.equity.ArBourse;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.file.ArFileUtil;
import com.arsoft.projects.common.number.ArNumberUtil;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;
import com.arsoft.projects.common.utility.datatime.ArDateTimeUtil;
import com.arsoft.projects.common.webservice.ArWebServiceUtil;

public class ArScripUtil implements Callable<String>{

	private String myAsset;
	
	public ArScripUtil(String myAsset){
		this.myAsset = myAsset;
	}
	
	public static String getScripData(String scrip, ArBourse arBourse){
		String url = "https://finance.google.com/finance/getprices?q="+scrip+"&x="+arBourse+"&p=1&i=1&f=c";
		String output = null;
		try {
			output = ArWebServiceUtil.excecute(url, null, null);
		} catch (ArException e) {
			output = "0";
		}
		int index = -1;
		for (int i = output.length()-1; i > 0 ; i--){
			if (String.valueOf(output.charAt(i)).equals("\n")){
				index = i;
				break;
			}
		}
		String value = output.substring(index + 1, output.length());
		return value;
	}
	
	@Override
	public String call() {
		return getScripData(myAsset, ArBourse.NSE);	
	}
	
	public static void main(String[] args) throws JSONException, ArException {
		String propertyFile ="stocks.properties";
		String propertyName = "stocks";
		String propertyValue = ArFileUtil.getProperty(propertyFile, propertyName);
		printSharePrice(propertyValue);
	}
	
	public static String getSharePriceHtml(String scrips){
		List<String> assetList = ArStringUtil.getStringAsListAfterTokenization(scrips, ArStringConstant.COMMA);
		Map<String, String> map = new LinkedHashMap<>();
		ExecutorService exec = Executors.newFixedThreadPool(assetList.size());
		List<Callable<String>> callables =  new ArrayList<Callable<String>>();
		StringBuffer bf = null;
        for(int i=0; i< assetList.size(); i++) {
            callables.add(new ArScripUtil(assetList.get(i)));
        }	
        try {
            List<Future<String>> results =  exec.invokeAll(callables);
            int i = 0;
            for(Future<String> result: results) {
            	map.put(assetList.get(i), result.get());
            	i++;
            }
            bf = new StringBuffer();
			bf.append("<table border=\"1\">");
			bf.append("<tr><th>Scrip Name</th><th>Scrip Value</th></tr>");
			for (Map.Entry<String, String> entryMap: map.entrySet()){
				bf.append("<tr><td>"+entryMap.getKey()+"</td><td>"+ (entryMap.getValue().equals("DATA=") ? ArScripConstant.SCRIP_NOT_FOUND : entryMap.getValue())+"</td></tr>");
    		}
			bf.append("</table>");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } finally {
            exec.shutdownNow();
        }
		return bf.toString();
	}
	
	public static JSONArray getSharePriceJson(String scrips){
		JSONArray jsonArray = null;
		ArScrip arScrip = null;
		List<String> assetList = ArStringUtil.getStringAsListAfterTokenization(scrips, ArStringConstant.COMMA);
		Map<String, String> map = new LinkedHashMap<>();
		ExecutorService exec = Executors.newFixedThreadPool(assetList.size());
		List<Callable<String>> callables =  new ArrayList<Callable<String>>();
        for(int i=0; i< assetList.size(); i++) {
            callables.add(new ArScripUtil(assetList.get(i)));
        }	
        try {
            List<Future<String>> results =  exec.invokeAll(callables);
            int i = 0;
            for(Future<String> result: results) {
            	map.put(assetList.get(i), result.get());
            	i++;
            }
			for (Map.Entry<String, String> entryMap: map.entrySet()){
				if (jsonArray == null){
					jsonArray = new JSONArray();
				}
				double value = 0f;
				try{
					value = Double.parseDouble(entryMap.getValue());
					arScrip= new ArScrip(entryMap.getKey(), entryMap.getKey(), ArBourse.NSE, value, ArDateTimeUtil.getCurrentArDateTime());
				}catch(NumberFormatException e){
					arScrip= new ArScrip(entryMap.getKey(), ArScripConstant.SCRIP_NOT_FOUND , ArBourse.NSE, value, ArDateTimeUtil.getCurrentArDateTime());
				}
				jsonArray.put(arScrip);
			}
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } finally {
            exec.shutdownNow();
        }
		return jsonArray;
	}
	
	public static Map<String, String> getSharePriceMap(String scrips){
		List<String> assetList = ArStringUtil.getStringAsListAfterTokenization(scrips, ArStringConstant.COMMA);
		Map<String, String> map = new LinkedHashMap<>();
		ExecutorService exec = Executors.newFixedThreadPool(assetList.size());
		List<Callable<String>> callables =  new ArrayList<Callable<String>>();
        for(int i=0; i< assetList.size(); i++) {
            callables.add(new ArScripUtil(assetList.get(i)));
        }	
        try {
            List<Future<String>> results =  exec.invokeAll(callables);
            int i = 0;
            for(Future<String> result: results) {
            	map.put(assetList.get(i), result.get());
            	i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } finally {
            exec.shutdownNow();
        }
		return map;
	}
	
	public static String printSharePrice(String scrips){
		List<String> assetList = ArStringUtil.getStringAsListAfterTokenization(scrips, ArStringConstant.COMMA);
		Map<String, String> map = new LinkedHashMap<>();
		ExecutorService exec = Executors.newFixedThreadPool(assetList.size());
		List<Callable<String>> callables =  new ArrayList<Callable<String>>();
        for(int i=0; i< assetList.size(); i++) {
            callables.add(new ArScripUtil(assetList.get(i)));
        }	
        try {
            List<Future<String>> results =  exec.invokeAll(callables);
            int i = 0;
            for(Future<String> result: results) {
            	map.put(assetList.get(i), result.get());
            	i++;
            }
            StringBuffer bf = new StringBuffer();
			bf.append("<table border=\"1\">");
			bf.append("<tr><th>Scrip Name</th><th>Scrip Value</th></tr>");
			for (Map.Entry<String, String> entryMap: map.entrySet()){
    			System.out.println(entryMap.getKey()+"="+entryMap.getValue());
    		}
			bf.append("</table>");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } finally {
            exec.shutdownNow();
        }
		return scrips;
	}

	public static ArScrip getArScrip(String scripName, ArBourse arBourse) throws ArException {
		String arScripPrice = getScripData(scripName, arBourse);
		if (!ArNumberUtil.isDouble(arScripPrice)){
			throw new ArException("Price not available for scrip: "+scripName+" at bourse: "+arBourse);
		}
		ArScrip arScrip = new ArScrip(scripName, scripName, arBourse, Double.parseDouble(arScripPrice), ArDateTimeUtil.getCurrentArDateTime());
		return arScrip;
	}

}
