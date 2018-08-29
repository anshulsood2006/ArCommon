package com.arsoft.projects.common.html;

public class ArHtmlUtil {
	
	public static String replaceHtmlEscapeCharacters(String str){
		for (String key: ArHtmlConstant.htmlEscapeCharacters.keySet())
		{
			str = str.replaceAll(key, ArHtmlConstant.htmlEscapeCharacters.get(key));
		}
		return str;
	}
	
}
