package com.arsoft.projects.common.webservice;

import static org.junit.Assert.assertNotNull;

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
import org.json.JSONObject;

import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.file.ArFileUtil;
import com.arsoft.projects.common.json.ArJsonUtil;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;

public class ArScripPrice implements Callable<String>{

	private String myAsset;
	
	public ArScripPrice(String myAsset){
		this.myAsset = myAsset;
	}
	
	@Override
	public String call() {
		String url = "http://finance.google.com/finance/info?q=NSE:"+myAsset;
		String output = null;
		try {
			output = ArWebServiceUtil.excecute(url, null, null);
		} catch (ArException e) {
			e.printStackTrace();
		}
		List<JSONObject> list = null;
		try {
			list = ArJsonUtil.getListOfJsonObject(output);
		} catch (JSONException | ArException e) {
			e.printStackTrace();
		}
		for (JSONObject jsonObject:list){
			String value = ArJsonUtil.getValue(jsonObject, "l");
			assertNotNull(value);
		}
		return output;	
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
            callables.add(new ArScripPrice(assetList.get(i)));
        }	
        try {
            List<Future<String>> results =  exec.invokeAll(callables);
            for(Future<String> result: results) {
                List<JSONObject> list = ArJsonUtil.getListOfJsonObject(result.get());
    			for (JSONObject jsonObject:list){
    				String key = ArJsonUtil.getValue(jsonObject, "t");
    				String value = ArJsonUtil.getValue(jsonObject, "l");
    				map.put(key, value);
    			}
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
