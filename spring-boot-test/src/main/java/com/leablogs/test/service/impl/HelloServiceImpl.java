package com.leablogs.test.service.impl;

//import org.springframework.transaction.annotation.Transactional;

import com.leablogs.test.service.HelloService;

public class HelloServiceImpl implements HelloService {

//	@Transactional
	@Override
	public void sayHello(String name) {
		if (name == null || name.trim() == "") {
			throw new RuntimeException("paramter is null!!");
		}
		System.out.println("hello " + name);
	}

}
