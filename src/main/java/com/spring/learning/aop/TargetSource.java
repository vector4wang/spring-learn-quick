package com.spring.learning.aop;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/3 0003
 * Time: 19:56
 * Description: 被代理对象 (全部都抽象出来)
 */
public class TargetSource {
	private Class targetClass;

	private Object target;

	public TargetSource(Class targetClass, Object target) {
		this.targetClass = targetClass;
		this.target = target;
	}

	public Class getTargetClass() {
		return targetClass;
	}

	public void setTargetClass(Class targetClass) {
		this.targetClass = targetClass;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
}
