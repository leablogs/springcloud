package com.leablogs.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello(@RequestParam String name) {
		return "hello " + name;
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public User hello(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age) {
		return new User(id, name, age);
	}

	@RequestMapping(value = "/hello3", method = RequestMethod.POST)
	public String hello(@RequestBody User user) {
		System.out.println("hello " + user.getName() + ", " + user.getAge());
		return "hello " + user.getName() + ", " + user.getAge();
	}

	@Data
	@AllArgsConstructor
	class User{
		private int id;
		private String name;
		private int age;
	}
}
