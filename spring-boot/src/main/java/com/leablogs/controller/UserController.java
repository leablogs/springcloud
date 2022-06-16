package com.leablogs.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
	private static final String REST_URL_PROVIDER_PREFIX_STRING = "http://YOU-SERVICE";
//	@Autowired
//	RestTemplate restTemplate;
	@Autowired
	private Environment environment;

	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public String getUserList(String param) {
//		String url = "http://eureka-server/test/?param=" + param;
//		return restTemplate.getForObject(url, String.class);
		System.out.println(environment);
		return "aaaaa";
	}
}
