package com.leablogs.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leablogs.feign.HelloService;

@RestController
public class ConsumerController {
	@Autowired
	HelloService helloService;

	@RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
	public String helloConsumer() {
		return helloService.hello();
	}

	@RequestMapping(value = "/feign-consumer1", method = RequestMethod.GET)
	public String helloConsumer1() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(helloService.hello()).append("\n");
		stringBuilder.append(helloService.hello("DIDI")).append("\n");
		stringBuilder.append(helloService.hello2(32, "DIDI", 23)).append("\n");
		stringBuilder.append(new User(2, "DIDI", 25)).append("\n");
		System.out.println(stringBuilder);
		return stringBuilder.toString();
	}
	@Data
	@AllArgsConstructor
	class User{
		private int id;
		private String name;
		private int age;
	}
}
