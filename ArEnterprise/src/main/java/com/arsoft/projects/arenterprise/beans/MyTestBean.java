package com.arsoft.projects.arenterprise.beans;

import com.arsoft.projects.arenterprise.annotation.TrackException;
	
public class MyTestBean {
	
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@TrackException
	public void testMe() {
		Mind.sayHello(age);
	}
}
