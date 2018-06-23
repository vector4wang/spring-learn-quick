package com.spring.learning.xml;

import com.spring.learning.AbstractBeanDefinitionReader;
import com.spring.learning.BeanDefinition;
import com.spring.learning.BeanReference;
import com.spring.learning.PropertyValue;
import com.spring.learning.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}

	public void loadBeanDefinitions(String location) throws Exception {
		InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
		doLoadBeanDefinitions(inputStream);
	}

	private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document parse = documentBuilder.parse(inputStream);

		registerBeanDefinitions(parse);
		inputStream.close();
	}

	private void registerBeanDefinitions(Document parse) {
		Element root = parse.getDocumentElement();
		parseBeanDefinitons(root);
	}

	private void parseBeanDefinitons(Element root) {
		NodeList childNodes = root.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				Element ele = (Element) node;
				processBeanDefinition(ele);
			}
		}
	}

	private void processBeanDefinition(Element ele) {
		String name = ele.getAttribute("name");
		String className = ele.getAttribute("class");
		BeanDefinition beanDefinition = new BeanDefinition();
		processProperty(ele, beanDefinition);
		beanDefinition.setBeanClassName(className);
		getRegistry().put(name, beanDefinition);
	}

	private void processProperty(Element ele, BeanDefinition beanDefinition) {
		NodeList property = ele.getElementsByTagName("property");
		for (int i = 0; i < property.getLength(); i++) {
			Node item = property.item(i);
			if (item instanceof Element) {
				Element element = (Element) item;
				String name = element.getAttribute("name");
				String value = element.getAttribute("value");
				if (value != null && value.length() > 0) {
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
				} else {
					String ref = element.getAttribute("ref");
					if (ref == null || ref.length() == 0) {
						throw new IllegalArgumentException(
								"Configuration problem: <property> element for property '" + name
										+ "' must specify a ref or value");
					}
					BeanReference beanReference = new BeanReference(ref);
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
				}
			}
		}
	}
}
