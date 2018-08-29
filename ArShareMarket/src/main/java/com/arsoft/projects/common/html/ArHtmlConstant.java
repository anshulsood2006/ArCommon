package com.arsoft.projects.common.html;

import java.util.HashMap;
import java.util.Map;

public class ArHtmlConstant {

	public static final Map<String, String> htmlEscapeCharacters;
	static{
		htmlEscapeCharacters = new HashMap<String, String>();
		htmlEscapeCharacters.put("&", "%26");
	}
	
	
	
}
