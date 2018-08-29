package com.arsoft.projects.common.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanManager implements ApplicationContextAware{

	static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		BeanManager.applicationContext = applicationContext;
	}
	
	public static Object getBean(String bean){
		return applicationContext.getBean(bean);
	}
	
	public static <T> T getBean(Class<T> bean){
		return applicationContext.getBean(bean);
	}
}
