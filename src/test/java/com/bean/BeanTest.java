package com.bean;

import com.bean.service.TwoService;
import com.spring.learning.context.ApplicationContext;
import com.spring.learning.context.ClassPathXmlApplicationContext;

public class BeanTest {
	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-diy.xml");
		TwoService twoService = (TwoService) applicationContext.getBean("twoService");
		twoService.two();
	}
}
