package com.bean;

import com.bean.service.HelloWorldService;
import com.spring.learning.BeanDefinition;
import com.spring.learning.BeanFactory;

public class BeanTest {
	public static void main(String[] args) {

		/**
		 * 定义hello service这个bean
		 */
		BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());

		BeanFactory factory = new BeanFactory();
		factory.registerBeanDefinition("helloWorld", beanDefinition);

		HelloWorldService helloWorld = (HelloWorldService) factory.getBean("helloWorld");
		helloWorld.say("diy spring");


	}
}
