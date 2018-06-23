package com.spring.learning;

import java.net.MalformedURLException;

public interface BeanDefinitionReader {
	void loadBeanDefinitions(String location) throws Exception;
}
