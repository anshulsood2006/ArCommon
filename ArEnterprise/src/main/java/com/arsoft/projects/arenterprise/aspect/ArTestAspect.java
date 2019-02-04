package com.arsoft.projects.arenterprise.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ArTestAspect {
	
	@After("pointCutMethod()")
	public void afterAdvice() {
		System.out.println("Executing advice after getAllArTestDto() method is called.");
	}
	
	@Before("pointCutMethod()")
	public void joinPointAdvice(JoinPoint joinpoint) {
		System.out.println("Executing joinPointAdvice before getAllArTestDto() method is called.");
		System.out.println("JoinPoint Arguments are: "+ joinpoint.getArgs()[0]  + " " + joinpoint.getArgs()[1]);
		System.out.println("JoinPoint Arguments are: "+Arrays.toString(joinpoint.getArgs()));
		System.out.println("JoinPoint Signature is: "+joinpoint.getSignature());
		System.out.println("JoinPoint Target Object is: "+joinpoint.getTarget());
	}
	
	@Before("args(String, int)")
	public void argsAdvice(JoinPoint joinpoint) {
		System.out.println("Executing argsAdvice before getAllArTestDto(name, type) method is called." + joinpoint.getArgs()[0]  + " " + joinpoint.getArgs()[1]);
	}

	@Pointcut("execution(* getAllArTestDto(*,*))")
	public void pointCutMethod() {}
	
	@AfterThrowing(pointcut="within(com.arsoft.projects.arenterprise.beans.ArTestDao)", throwing="e")
	public void withinAdvice(JoinPoint joinPoint, Throwable e) {
		System.out.println("Executing advice @AfterThrowing " + e.getLocalizedMessage());
	}
	
	@AfterReturning(value="execution(* getAllArTestDto(*,*))", returning = "result")
	public void returnAdvice(JoinPoint joinPoint, Object result) {
		System.out.println("Executing returnAdvice object returned is: " + result +"  "+joinPoint);
	}
	
	@Around(value="within(com.arsoft.projects.arenterprise.beans.ArTestDao)")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object value = null;
		System.out.println("Executing aroundAdvice before ");
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Executing aroundAdvice after" );
		return value;
	}
	
	@Around("@annotation(com.arsoft.projects.arenterprise.annotation.ArTestAnnotation)")
	public Object customAnnotationAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object value = null;
		System.out.println("Executing customAnnotationAdvice before ");
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Executing customAnnotationAdvice after" );
		return value;
	}
	
}
