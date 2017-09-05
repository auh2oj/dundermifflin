package com.josh.dundermifflin.aop.advice;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class DaoAdviceLogger {

	@Before("execution(* com.josh.dundermifflin.dao.impl.*.*(..))")
	public void beforeLogger(JoinPoint joinPoint) {
		String className= joinPoint.getTarget().getClass().getName();
		Date logDate = new Date();
		System.out.println("##############################");
		System.out.println("Log at "+ logDate + ": Method called: " + className + "." + joinPoint.getSignature().getName());
		System.out.println("Input for method: " + joinPoint.getArgs());
		System.out.println("##############################");
	}
	
}
