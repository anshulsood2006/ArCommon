package com.arsoft.projects.common.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsoft.projects.common.exception.ArException;

public class ArFileUtil {
	
	private final static Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	public static String getFileContentAsString(String filePath) throws IOException, ArException{
		InputStream is = null;
		if (filePath == null){
			throw new ArException("File location can not be null or empty");
		}
		logger.info("Reading file at path "+ filePath);
		try{
			is = new FileInputStream(filePath); 
		}catch(FileNotFoundException e){
			throw new ArException("Incorrect file location "+filePath);
		}
		BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 
		String line = buf.readLine(); 
		StringBuilder sb = new StringBuilder(); 
		while(line != null){ 
			sb.append(line).append(ArFileConstant.NEW_LINE); 
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
	
	public static String getProperty(String propertyFile, String propertyName) throws ArException{
		String propertyValue = null;
		InputStream  inputStream = null;
		Properties prop = new Properties();
		try {
			inputStream = ArFileUtil.class.getClassLoader().getResourceAsStream(propertyFile);
			prop.load(inputStream);
			propertyValue = prop.getProperty(propertyName);
			if (propertyValue == null){
				throw new ArException("Property "+propertyName +" not found in the file "+ propertyFile+".");
			}
		} catch (IOException io) {
			io.printStackTrace();
			throw new ArException("Error opening properties file "+propertyFile +". Check if the file is on the classpath.");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return propertyValue;
	}
}
