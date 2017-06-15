package com.arsoft.projects.common.string;

import java.util.logging.Logger;

public class ArStringUtil {
	
	private static final Logger logger = Logger.getLogger(ArStringUtil.class.getName());
	
	public static String removeFromStartIndex(String actualString, String stringToBeRemovedFromStart){
		if (actualString == null || actualString.length() == 0){
			return actualString;
		}else{
			if (stringToBeRemovedFromStart != null && actualString.startsWith(stringToBeRemovedFromStart)){
				actualString = actualString.substring(actualString.indexOf(stringToBeRemovedFromStart)+stringToBeRemovedFromStart.length(), actualString.length());
				return actualString;
			}
			else{
				return actualString;
			}
		}
		
	}
}
