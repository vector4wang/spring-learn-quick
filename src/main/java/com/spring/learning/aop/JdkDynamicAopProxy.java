package com.spring.learning.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/3 0003
 * Time: 20:05
 * Description: 
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

	private AdvisedSupport advisedSupport;

	public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
		this.advisedSupport = advisedSupport;
	}

	@Override
	public Object getProxy() {
		return Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class[]{advisedSupport.getTargetSource().getTargetClass()}, this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MethodInterceptor methodInterceptor = advisedSupport.getMethodInterceptor();
		return methodInterceptor
				.invoke(new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(), method, args));
	}
}
