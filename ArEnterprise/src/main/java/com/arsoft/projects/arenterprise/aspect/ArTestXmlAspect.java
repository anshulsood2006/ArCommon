package com.arsoft.projects.arenterprise.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class ArTestXmlAspect {
	
	public Object xmlAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object value = null;
		System.out.println("Executing xmlAdvice before ");
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Executing xmlAdvice after" );
		return value;
	}
	
}
