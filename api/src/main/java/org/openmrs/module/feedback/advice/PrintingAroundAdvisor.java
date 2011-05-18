package org.openmrs.module.feedback.advice;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

public class PrintingAroundAdvisor extends StaticMethodMatcherPointcutAdvisor implements Advisor {

	private static final long serialVersionUID = 3333L;

	private Log log = LogFactory.getLog(this.getClass());
	
	public boolean matches(Method method, Class targetClass) {
		if (method.getName().startsWith("get"))
			return true;
		return false;
	}

	@Override
	public Advice getAdvice() {
		log.error("Getting new around advice");
		return new PrintingAroundAdvice();
	}
	
	private class PrintingAroundAdvice implements MethodInterceptor {
		public Object invoke(MethodInvocation invocation) throws Throwable {
			
			log.error("Before " + invocation.getMethod().getName() + ".");
			
			Object o = invocation.proceed();
			
			log.error("After " + invocation.getMethod().getName() + ".");
			
			return o;
		}
	}
	
}