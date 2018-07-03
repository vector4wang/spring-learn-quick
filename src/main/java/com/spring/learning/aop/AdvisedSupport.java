package com.spring.learning.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/3 0003
 * Time: 20:04
 * Description: 
 */
public class AdvisedSupport {
	private TargetSource targetSource;

	private MethodInterceptor methodInterceptor;

	public TargetSource getTargetSource() {
		return targetSource;
	}

	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}

	public MethodInterceptor getMethodInterceptor() {
		return methodInterceptor;
	}

	public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
		this.methodInterceptor = methodInterceptor;
	}
}
