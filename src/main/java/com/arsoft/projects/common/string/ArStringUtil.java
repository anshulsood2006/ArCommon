package com.arsoft.projects.common.string;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.InputSource;

public class ArStringUtil {
	
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
	
	public static boolean isValidXML(String inXMLStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            builder.parse( new InputSource(new StringReader(inXMLStr) ) ); 
            return true;
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;
        } 
    }
	
	public static List<String> getStringAsListAfterTokenization(String string, String tokenizer){
		List<String> listOfString = new ArrayList<>();
		if (string == null){
			return listOfString;
		}
		if (tokenizer == null){
			listOfString.add(string);
			return listOfString;
		}
		StringTokenizer stringTokenizer = new StringTokenizer(string, tokenizer) ;
		while (stringTokenizer.hasMoreTokens()){
			listOfString.add(stringTokenizer.nextToken());
		}
		return listOfString;
	}
	
	public static boolean isNullOrEmptyString(String string){
		if (string == null || string.equals(ArStringConstant.EMPTY_STRING)){
			return true;
		}else{
			return false;
		}
	}
	
	public static String[] splitString(String str, String pattern) {
		if (str == null) {
			return null;
		}
		if (pattern == null || pattern.length() == 0) {
			return str.split(ArStringConstant.EMPTY_STRING);
		}
		return str.split(Pattern.quote(pattern));
	}
	
}
