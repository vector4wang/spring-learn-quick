package com.spring.learning;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {

	/**
	 * 存储bean的map
	 */
	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

	public Object getBean(String name) {
		return beanDefinitionMap.get(name).getBean();
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(name, beanDefinition);
	}

}
