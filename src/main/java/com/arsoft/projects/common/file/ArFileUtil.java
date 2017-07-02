package com.arsoft.projects.common.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArFileUtil {
	
	public static String readFile(String filePath) throws IOException{
		InputStream is = new FileInputStream(filePath); 
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
}
