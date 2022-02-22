package com.leablogs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public String getUserList() {
		return restTemplate.getForEntity("http://getUser/getUserList", String.class).getBody();
	}
}
