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
	
	public static String readFile(String filePath) throws IOException{
		InputStream is = new FileInputStream(filePath); 
		BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 
		String line = buf.readLine(); 
		StringBuilder sb = new StringBuilder(); 
		while(line != null){ 
			sb.append(line).append("\n"); 
			line = buf.readLine(); 
		} 
		buf.close();
		String fileAsString = sb.toString(); 
		return fileAsString;
	}
	
	public static List<File> getFoldersAtPath(String path){
		List<File> folderList = new ArrayList<>();
		File file = new File(path);
		String[] names = file.list();
		for(String name : names)
		{
			String filePath = path + File.separator + name;
		    if (new File(filePath).isDirectory())
		    {
		    	folderList.add(new File(filePath));
		    }
		}
		return folderList;
	}
	
	public static List<File> getFilesAtPath(String path){
		List<File> fileList = new ArrayList<>();
		File file = new File(path);
		String[] names = file.list();
		for(String name : names)
		{
			String filePath = path + File.separator + name;
		    if (!new File(filePath).isDirectory())
		    {
		    	fileList.add(new File(filePath));
		    }
		}
		return fileList;
	}
}
