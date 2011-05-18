package org.openmrs.module.feedback.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class CountingBeforeAdvice implements MethodBeforeAdvice {

	private Log log = LogFactory.getLog(this.getClass());

	private int count = 0;

	public void before(Method m, Object[] args, Object target) throws Throwable {
		log.error("Method: " + m.getName() + ". Before advice called " + (++count) + " time(s) now.");
	}
	
}