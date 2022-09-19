package com.leablogs.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class TimeRecordAspect {
    @Pointcut("execution(* com.leablogs..*Controller.*(..))")
    public void timeRecord() {

    }

    @Before(value = "timeRecord()")
    public void recordTimeBefore(JoinPoint jp) {
    }

    public void recordTimeAfter(JoinPoint jp) {
    }

    @AfterReturning(returning = "rvt", pointcut = "timeRecord()")
    public void recordTimeReturning(Object rvt) {
    }

    @Around("timeRecord()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object[] objects = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("请求参数：【{}】", joinPoint.getArgs());
        Object result = joinPoint.proceed();
        log.info("整个请求消耗时间：【{}】ms", System.currentTimeMillis() - start);
        return result;
    }
}
