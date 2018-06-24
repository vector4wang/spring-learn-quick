package com.spring.learning;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
	private List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	public void addPropertyValue(PropertyValue propertyValue) {
		this.propertyValues.add(propertyValue);
	}
}
