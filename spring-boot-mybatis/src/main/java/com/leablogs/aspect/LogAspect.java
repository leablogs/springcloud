package com.leablogs.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.leablogs.annotation.SystemLogs;

@Aspect
@Order(1)
@Component
public class LogAspect {
//	@Pointcut("execution(* com.leablogs.controller.TestController.getAllOne(..))")
	@Pointcut("@annotation(com.leablogs.annotation.SystemLogs)")
	public void pointCut() {
		
	}
	@Before("pointCut()")
	public void before() {
		System.out.println("before====================");
	}

	@After("pointCut()")
	public void after() {
		System.out.println("after==================");
	}

	@AfterReturning("pointCut()")
	public void afterReturn() {
		System.out.println("afterreturn================");
	}

	@AfterThrowing("pointCut()")
	public void afterException() {
		System.err.println("afger exception=====================");
	}

//	@Around("pointCut()")
//	public void around(ProceedingJoinPoint jp) throws Throwable {
//		System.out.println("arount before============");
//		jp.proceed();
//		System.out.println("around after=============");
//	}
}
