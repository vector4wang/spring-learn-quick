package com.bean.service;

public class HelloWorldServiceImpl implements HelloWorldService {
	private String str;

	public void setStr(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void say() {
		System.out.println("hello " + str);
	}
}
