package com.arsoft.projects.common.json;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;

public class ArJsonUtil {
	private static final Logger logger = Logger.getLogger(ArJsonUtil.class.getName());
	
	public static List<JSONObject> getListOfJsonObject(String str) throws JSONException, ArException{
		List<JSONObject> listOfJsonObject = new ArrayList<>();
		if (isValidJasonArray(str)){
			JSONArray jsonArray = getJsonArray(str);
			if (jsonArray != null){
				for (int index = 0; index < jsonArray.length(); index ++)
				{
					JSONObject jsonObject = jsonArray.getJSONObject(index);
					logger.info("JsonObject is "+ jsonObject);
					listOfJsonObject.add(jsonObject);
				}
			}
		}
		logger.info("List of JSONObject is: "+listOfJsonObject);
		return listOfJsonObject;
	}
	
	public static boolean isValidJasonArray(String str) throws ArException{
		String originalString = str;
		boolean isValid = true;
		if (str == null || str.length() == 0 || str.indexOf("[") == 0 && str.indexOf("]") == 0){
			isValid =  false;
		}else{
			try{
				if (str.startsWith(ArStringConstant.INLINE_COMMENT)){
					str = removeComments(str, ArStringConstant.INLINE_COMMENT);
				}
				JSONArray jsonArray = new JSONArray(str);
				for (int index = 0; index < jsonArray.length(); index ++)
				{
					try{
						jsonArray.getJSONObject(index);
					}catch(Exception e){
						logger.severe(originalString+" is not a valid JSONArray");
						return false;
					}
				}
				isValid =  true;
			}catch(Exception e){
				isValid =  false;
			}
		}
		if(isValid){
			logger.info(originalString+" is a valid JSONArray");
		}else{
			logger.severe(originalString+" is not a valid JSONArray");
		}
		return isValid;
	}
	
	public static JSONArray getJsonArray(String str) throws ArException{
		if (isValidJasonArray(str)){
			if (str.startsWith(ArStringConstant.INLINE_COMMENT)){
				str = removeComments(str, ArStringConstant.INLINE_COMMENT);
			}
			return new JSONArray(str);
		}
		else{
			throw new ArException("Given string "+str+" can not be converted to a JSONarray");
		}
	}

	private static String removeComments(String actualString, String stringToBeRemovedFromStart) {
		actualString = ArStringUtil.removeFromStartIndex(actualString, stringToBeRemovedFromStart);
		return actualString;
	}
	
	public static String getValue(JSONObject jsonObject, String name){
		return jsonObject.getString(name);
	}
	
}
