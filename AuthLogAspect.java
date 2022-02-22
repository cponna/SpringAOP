package com.around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AuthLogAspect implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("Authentication done!");

		Object obj = invocation.proceed();
		System.out.println("Logging info stored!");
		return null;
	}


}