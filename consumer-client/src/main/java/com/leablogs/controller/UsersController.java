package com.leablogs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leablogs.service.UserService;

@RestController
public class UsersController {
	@Autowired
	UserService userService;

	@GetMapping(value = "/user/findAll")
	public Map<String, String> findAll() {
		return userService.findAll();
	}

	@RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
	public String helloConsumer() {
		return userService.helloService();
	}
}
