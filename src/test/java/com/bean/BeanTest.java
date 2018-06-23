package com.bean;

import com.bean.service.HelloWorldService;
import com.spring.learning.BeanDefinition;
import com.spring.learning.factory.AutowireCapableBeanFactory;
import com.spring.learning.factory.BeanFactory;

public class BeanTest {
	public static void main(String[] args) {

		/**
		 * 初始化Bean工厂
		 */
		BeanFactory beanFactory = new AutowireCapableBeanFactory();

		/**
		 * 定义bean
		 */
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("com.bean.service.HelloWorldService");

		/**
		 * zhurubean
		 */
		beanFactory.registerBeanDefinition("helloWorld", beanDefinition);

		/**
		 * 使用Bean
		 */
		HelloWorldService helloWorld = (HelloWorldService) beanFactory.getBean("helloWorld");
		helloWorld.say("diy spring");
	}
}
