package com.bean.aop;

import com.bean.service.HelloWorldService;
import com.bean.service.TwoService;
import com.spring.learning.aop.AdvisedSupport;
import com.spring.learning.aop.JdkDynamicAopProxy;
import com.spring.learning.aop.TargetSource;
import com.spring.learning.context.ApplicationContext;
import com.spring.learning.context.ClassPathXmlApplicationContext;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/7/3 0003
 * Time: 20:24
 * Description: 
 */
public class AopTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-diy.xml");
		HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
		helloWorldService.say();

		System.out.println("=========================AOP========================");

		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(HelloWorldService.class,helloWorldService);
		advisedSupport.setTargetSource(targetSource);

		LogInterceptor logInterceptor = new LogInterceptor();
		advisedSupport.setMethodInterceptor(logInterceptor);

		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);

		HelloWorldService proxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();
		proxy.say();

	}
}

