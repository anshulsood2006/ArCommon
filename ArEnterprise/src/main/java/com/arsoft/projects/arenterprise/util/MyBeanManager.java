package com.arsoft.projects.arenterprise.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.arsoft.projects.arenterprise.beans.ArBean;

public class MyBeanManager implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		MyBeanManager.applicationContext = applicationContext;		
	}
	
	public static Object getBean(String requiredType){
		return applicationContext.getBean(requiredType);
	}
	
	static public <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
	public void myInit() {
		ArBean arBean = (ArBean) MyBeanManager.getBean("arBean");
		System.out.println("Name via MyBeanManager: "+arBean.getName());
		System.out.println("Age via MyBeanManager: "+arBean.getAge());
		System.out.println("Address via MyBeanManager: "+arBean.getArBeanObject().getAddress());
	}

}
