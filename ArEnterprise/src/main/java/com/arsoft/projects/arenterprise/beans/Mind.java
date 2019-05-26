package com.arsoft.projects.arenterprise.beans;

import com.arsoft.projects.arenterprise.annotation.TrackException;

public class Mind {
	
	@TrackException
	public static void sayHello(int age) {	
		System.out.println("Hello friend with age: "+age);
	}
}
