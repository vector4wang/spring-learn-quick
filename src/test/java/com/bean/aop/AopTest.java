package com.bean.aop;

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
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-div.xml");
		TwoService twoService = (TwoService) context.getBean("twoService");
		twoService.two();

		System.out.println("=========================AOP========================");

		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(TwoService.class,twoService);
		advisedSupport.setTargetSource(targetSource);

		LogInterceptor logInterceptor = new LogInterceptor();
		advisedSupport.setMethodInterceptor(logInterceptor);

		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);

		TwoService proxy = (TwoService) jdkDynamicAopProxy.getProxy();
		proxy.two();

	}
}

