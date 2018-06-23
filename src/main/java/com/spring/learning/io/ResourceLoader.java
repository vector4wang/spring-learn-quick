package com.spring.learning.io;

import java.net.URL;

public class ResourceLoader {
	public Resource getResource(String loaction) {
		URL resource = this.getClass().getClassLoader().getResource(loaction);
		return new UrlResource(resource);
	}
}
