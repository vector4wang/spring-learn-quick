package com.spring.learning.simple1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/6/15 0015
 * Time: 10:58
 * Description: https://github.com/seaswalker/Spring/blob/master/note/Spring.md
 */
public class TestMain {
	public static void main(String[] args) {
		/**
		 * 1、如何加载到资源
		 * 2、如何根据Helloworld.class获取对应实力
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:config.xml");
		HelloWorld bean = context.getBean(HelloWorld.class);
		bean.hello("wangxc");
		context.close();
	}
}
