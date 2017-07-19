package com.arsoft.projects.common.webservice;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.json.ArJsonUtil;

public class ArScripPrice implements Callable<String>{

	private String myAsset;
	private int threadId;
	
	public ArScripPrice(String myAsset, int threadId){
		this.myAsset = myAsset;
		this.threadId = threadId;
	}
	
	@Override
	public String call() {
		String url = "http://finance.google.com/finance/info?q=NSE:"+myAsset;
		String output = null;
		try {
			output = ArWebServiceUtil.excecute(url, null, null);
		} catch (ArException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<JSONObject> list = null;
		try {
			list = ArJsonUtil.getListOfJsonObject(output);
		} catch (JSONException | ArException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (JSONObject jsonObject:list){
			String value = ArJsonUtil.getValue(jsonObject, "l");
			assertNotNull(value);
		}
		return output;	
	}
	
	public static void main(String[] args) throws JSONException, ArException {
		Map<String, String> map = new LinkedHashMap<>();
		String[] asset = {"RPOWER","JSWENERGY","COALINDIA","NATIONALUM","IDEA","ASHOKLEY","NMDC","BHEL","PFC","DIVISLAB","JINDALSTEL","GMRINFRA","TATAPOWER","NETWORK18","HATHWAY","SAIL","IFCI","VIDEOIND","HINDCOMPOS","IDFC","SINTEX","TATASTEEL","ITC","SCHAND","TATAPOWER","IBVENTURES","VAKRANGEE"}; 
		List<String> assetList = Arrays.asList(asset); 
		ExecutorService exec = Executors.newFixedThreadPool(assetList.size());
		List<Callable<String>> callables =  new ArrayList<Callable<String>>();
        for(int i=0; i< assetList.size(); i++) {
            callables.add(new ArScripPrice(assetList.get(i), i+1));
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
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } finally {
            exec.shutdownNow();
        }
	}

}
