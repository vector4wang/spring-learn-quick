package com.spring.learning.factory;

import com.spring.learning.BeanDefinition;
import com.spring.learning.PropertyValue;
import com.spring.learning.PropertyValues;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		Object bean = createBeanInstance(beanDefinition);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}

	private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
		PropertyValues propertyValues = beanDefinition.getPropertyValues();
		for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			declaredField.setAccessible(true);
			declaredField.set(bean, propertyValue.getValue());
		}
	}

	private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}
}
