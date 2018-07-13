package com.arsoft.projects.common.number;

public class ArNumberUtil {
	public static boolean isDouble(String stringToCheck){
		boolean isDouble = false;
		try{
			Double.parseDouble(stringToCheck);
			isDouble = true;
		}catch(Exception e){
			isDouble = false;
		}
		return isDouble;
	}
}
