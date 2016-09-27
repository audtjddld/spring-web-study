package com.study.myhome.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
//@Aspect
public class GlobalLogging {

	private static Logger LOG = LoggerFactory.getLogger(GlobalLogging.class);
	
	//@Before("execution(* com.study.myhome..*Controller.*(..))")
	public void loggingAdvice(JoinPoint joinPoint) {
		Class clazz = joinPoint.getTarget().getClass();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(className + "." + methodName + " executed.");
	}
	
}
	