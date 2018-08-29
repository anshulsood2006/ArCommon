package com.arsoft.projects.common.java;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import com.arsoft.projects.common.exception.ArException;

public class ArJavaUtil {
	
	public static void compileClass(String fullyQualifiedclassName) throws ArException{
		JavaCompiler compiler;
		try{
			compiler = ToolProvider.getSystemJavaCompiler();
			compiler.run(null, null, null, fullyQualifiedclassName);
		}catch(Exception e){
			e.printStackTrace();
			throw new ArException("");
		}
		
	}
}
