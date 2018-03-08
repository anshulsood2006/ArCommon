package com.arsoft.projects.common.webservice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.json.JSONException;

import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.file.ArFileUtil;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;

public class ArScripPriceNew implements Callable<String>{

	private String myAsset;
	
	public ArScripPriceNew(String myAsset){
		this.myAsset = myAsset;
	}
	
	@Override
	public String call() {
		String url = "https://finance.google.com/finance/getprices?q="+myAsset+"&x=NSE&p=1&i=1&f=c";
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
	
	public static void main(String[] args) throws JSONException, ArException {
		String propertyFile ="stocks.properties";
		String propertyName = "stocks";
		String propertyValue = ArFileUtil.getProperty(propertyFile, propertyName);
		printSharePrice(propertyValue);
	}
	
	public static String getSharePrice(String scrips){
		List<String> assetList = ArStringUtil.getStringAsListAfterTokenization(scrips, ArStringConstant.COMMA);
		Map<String, String> map = new LinkedHashMap<>();
		ExecutorService exec = Executors.newFixedThreadPool(assetList.size());
		List<Callable<String>> callables =  new ArrayList<Callable<String>>();
		StringBuffer bf = null;
        for(int i=0; i< assetList.size(); i++) {
            callables.add(new ArScripPriceNew(assetList.get(i)));
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
				bf.append("<tr><td>"+entryMap.getKey()+"</td><td>"+entryMap.getValue()+"</td></tr>");
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
	
	public static String printSharePrice(String scrips){
		List<String> assetList = ArStringUtil.getStringAsListAfterTokenization(scrips, ArStringConstant.COMMA);
		Map<String, String> map = new LinkedHashMap<>();
		ExecutorService exec = Executors.newFixedThreadPool(assetList.size());
		List<Callable<String>> callables =  new ArrayList<Callable<String>>();
        for(int i=0; i< assetList.size(); i++) {
            callables.add(new ArScripPriceNew(assetList.get(i)));
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

}
