package com.bean.service;

public class HelloWorldService {

	private String str;

	public void setStr(String str) {
		this.str = str;
	}

	public void say() {
		System.out.println("hello " + str);
	}


}
