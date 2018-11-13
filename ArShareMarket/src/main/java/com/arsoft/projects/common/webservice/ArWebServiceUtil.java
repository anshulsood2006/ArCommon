package com.arsoft.projects.common.webservice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsoft.projects.arshared.exception.ArException;

public class ArWebServiceUtil {
	
	private static final Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	/*
	 * This method returns the response returned by the given web service url.
	 * @param String webServiceUrl URL of the web service.
	 * @param ArHttpMethod httpMethod the web method on which the request needs to be submitted.
	 * @param Map<String, String> requestPropertyMap the property map to set the request parameters
	 * @return response string
	 */
	public static String excecute(String webServiceUrl, ArHttpMethod httpMethod, Map<String, String> requestPropertyMap) throws ArException{
		HttpURLConnection httpConnection = null;
		BufferedReader br = null;
		URL url = null;
		String output = "";
		logger.debug("Web url is "+webServiceUrl);
		logger.debug("Http method is "+httpMethod);
		logger.debug("Request property map is "+requestPropertyMap);
		if (webServiceUrl == null)
		{
			logger.error("URL can not be entry.");
			throw new ArException("URL can not be entry.");
		}
		try {
			url = new URL(webServiceUrl);
			httpConnection = (HttpURLConnection) url.openConnection();
			if (httpMethod != null)
			{
				httpConnection.setRequestMethod(httpMethod.getHttpMethod());
			}
			if (requestPropertyMap != null)
			{
				for (Map.Entry<String, String> entry : requestPropertyMap.entrySet()){
					String key = entry.getKey();
					String value = entry.getValue();
					httpConnection.setRequestProperty(key, value);
				}
			}
			br = new BufferedReader(new InputStreamReader(
					(httpConnection.getInputStream())));
			String line;
			while ((line = br.readLine()) != null) {
				output = output + "\n" +line ;
			}
			httpConnection.disconnect();
			
		} catch (MalformedURLException e) {
			logger.error("URL is malformed.");
			throw new ArException(e.getLocalizedMessage());
		}catch (FileNotFoundException e) {
			logger.error("The URL "+webServiceUrl +" does not exist");
			throw new ArException("The URL "+webServiceUrl +" does not exist");
		}  catch (IOException e) {
			e.printStackTrace();
			throw new ArException(e.getLocalizedMessage());
		}
		logger.debug("Output is "+output);
		if (output.equals("")){
			output = null;
		}
		return output; 		
	}
			
}
