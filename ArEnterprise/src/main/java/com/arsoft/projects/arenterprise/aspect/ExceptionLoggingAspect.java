package com.arsoft.projects.arenterprise.aspect;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExceptionLoggingAspect
{
    protected Logger logger = LogManager.getLogManager().getLogger("MyTracker");
    
    @Around("@annotation(com.arsoft.projects.arenterprise.annotation.TrackException)")
	public Object exceptionLoggingAspectAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object value = null;
		System.out.println("Executing exceptionLoggingAspectAdvice before ");
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Executing exceptionLoggingAspectAdvice after" );
		return value;
	}
}