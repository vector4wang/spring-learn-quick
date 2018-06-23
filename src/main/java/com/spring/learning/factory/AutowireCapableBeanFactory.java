package com.spring.learning.factory;

import com.spring.learning.BeanDefinition;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	protected Object doCreateBean(BeanDefinition beanDefinition) {
		try {
			Object bean = beanDefinition.getBeanClass().newInstance();
			return bean;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}
}
