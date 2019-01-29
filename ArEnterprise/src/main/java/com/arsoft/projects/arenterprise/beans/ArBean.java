package com.arsoft.projects.arenterprise.beans;

import org.springframework.beans.factory.annotation.Required;

public class ArBean {
	
	private String name;
	private int age;
	
	private ArBeanObject arBeanObject;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void init() {
		System.out.println("Init method of ArBean called");
	}
	
	public ArBeanObject getArBeanObject() {
		return arBeanObject;
	}
	
	@Required
	public void setArBeanObject(ArBeanObject arBeanObject) {
		this.arBeanObject = arBeanObject;
	}
}
