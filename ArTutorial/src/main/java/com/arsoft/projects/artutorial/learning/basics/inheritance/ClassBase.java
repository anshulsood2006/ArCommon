package com.arsoft.projects.artutorial.learning.basics.inheritance;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassBase {
	private Logger logger = Logger.getLogger(ClassBase.class.getName());
	public void sayHello(){
		System.out.println("Hello from base class");
		String a= "Anshul";
		String b= "Sood";
		int z = 10;
		logger.log(Level.SEVERE, "Hello {0}", z);
		logger.log(Level.SEVERE, "Hello {0} {1} {2}", new Object[]{a,b,z});
		logger.log(Level.SEVERE, "Hello {} {} {}", new Object[]{a,b,z});
	}
	public static void main(String[] args) {
		ClassBase b = new ClassBase();
		b.sayHello();
	}
}
