package com.bean.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/3 0003
 * Time: 20:19
 * Description: 
 */
public class LogInterceptor implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("start record log ");
		Object proceed = invocation.proceed();
		System.out.println("end  record log");
		return proceed;
	}
}
