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
		String url = "https://www.google.com/finance/getprices?q="+myAsset+"&i=3600&p=1d&x=NSE&f=c";
		String output = null;
		try {
			output = ArWebServiceUtil.excecute(url, null, null);
		} catch (ArException e) {
			e.printStackTrace();
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
		List<String> assetList = ArStringUtil.getStringAsListAfterTokenization(propertyValue, ArStringConstant.COMMA);
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
            for (Map.Entry<String, String> entryMap: map.entrySet()){
    			System.out.println(entryMap.getValue());
    		}
            System.out.println("#############################################################");
    		for (Map.Entry<String, String> entryMap: map.entrySet()){
    			System.out.println(entryMap.getKey()+"="+entryMap.getValue());
    		}
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } finally {
            exec.shutdownNow();
        }
	}

}
