package com.study.myhome.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GlobalLogging {

	private static Logger LOG = LoggerFactory.getLogger(GlobalLogging.class);
	
	@Before("execution(* com.study.myhome.main.web.MainController.*(..))")
	public void loggingAdvice(JoinPoint joinPoint) {
		
		System.out.println("::::::::::::::::::::::::");
		LOG.info("flow : {}", joinPoint.getSourceLocation());
		
		Class clazz = joinPoint.getTarget().getClass();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AspectUsingAnnotation.beforeTargetMethod executed.");
        System.out.println(className + "." + methodName + " executed.");
		
		Object params[] = joinPoint.getArgs();
		for (Object param : params) {
			LOG.info("param : {}", param);
		}
	}
}
