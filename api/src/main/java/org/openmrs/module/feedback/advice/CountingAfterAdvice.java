package org.openmrs.module.feedback.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class CountingAfterAdvice implements AfterReturningAdvice {

	private Log log = LogFactory.getLog(this.getClass());

	private int count = 0;

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		log.error("Method: " + method.getName() + ". After advice called " + (++count) + " time(s) now.");
	}
	
}