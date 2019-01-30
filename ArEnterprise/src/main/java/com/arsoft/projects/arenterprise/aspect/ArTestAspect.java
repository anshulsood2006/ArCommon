package com.arsoft.projects.arenterprise.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ArTestAspect {
	
	@After("execution(* getAllArTestDto())")
	public void beforeAdvice() {
		System.out.println("Executing advice after getAllArTestDto() method is called.");
	}

}
