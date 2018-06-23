package com.spring.learning.factory;

import com.spring.learning.BeanDefinition;

public interface BeanFactory {

	Object getBean(String name);

	void registerBeanDefinition(String name, BeanDefinition beanDefinition);

}
