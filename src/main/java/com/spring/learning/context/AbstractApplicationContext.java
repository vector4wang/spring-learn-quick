package com.spring.learning.context;

import com.spring.learning.factory.AbstractBeanFactory;

public class AbstractApplicationContext implements ApplicationContext {

	protected AbstractBeanFactory beanFactory;

	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public Object getBean(String name) {
		return beanFactory.getBean(name);
	}

	public void refresh() throws Exception {

	}


}
