package com.bean.service;

public class TwoService {
	private HelloWorldService helloWorldService;

	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	public void print() {
		System.out.println("two " + helloWorldService.getStr());
	}
}
