package com.arsoft.projects.common.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.InputSource;

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
	
}
