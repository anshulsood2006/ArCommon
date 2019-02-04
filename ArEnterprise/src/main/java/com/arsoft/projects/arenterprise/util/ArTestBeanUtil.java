package com.arsoft.projects.arenterprise.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.arsoft.projects.arenterprise.beans.ArBean;

public class ArTestBeanUtil {
	
	
	private ApplicationContext applicationContext;
	
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	public void main() {
		ArBean arBean = (ArBean) applicationContext.getBean("arBean");
		System.out.println("Name: "+arBean.getName());
		System.out.println("Age: "+arBean.getAge());
		System.out.println("Address: "+arBean.getArBeanObject().getAddress());
	}
}
