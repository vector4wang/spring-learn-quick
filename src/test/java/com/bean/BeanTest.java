package com.bean;

import com.bean.service.HelloWorldService;
import com.spring.learning.BeanDefinition;
import com.spring.learning.factory.AutowireCapableBeanFactory;
import com.spring.learning.factory.BeanFactory;
import com.spring.learning.io.ResourceLoader;
import com.spring.learning.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanTest {
	public static void main(String[] args) throws Exception {

		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());

		xmlBeanDefinitionReader.loadBeanDefinitions("spring-diy.xml");

		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry()
				.entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}

		/**
		 * 使用Bean
		 */
		HelloWorldService helloWorld = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorld.say();
	}
}
