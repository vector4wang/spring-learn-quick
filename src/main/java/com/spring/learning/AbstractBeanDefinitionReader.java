package com.spring.learning;


import com.spring.learning.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

	private Map<String, BeanDefinition> registry;

	private ResourceLoader resourceLoader;

	protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		this.registry = new HashMap<String, BeanDefinition>();
	}

	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}
}
