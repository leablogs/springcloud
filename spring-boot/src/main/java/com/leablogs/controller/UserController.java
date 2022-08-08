package com.leablogs.controller;

import javax.annotation.Resource;

import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
//	private static final String REST_URL_PROVIDER_PREFIX_STRING = "http://YOU-SERVICE";
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
//	@Autowired
//	RestTemplate restTemplate;
//	@Autowired
//	private Environment environment;

	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public String getUserList(String param) {
//		log.isInfoEnabled();
//		log.info("---------------");
//		log.debug("---------------");
//		log.error("---------------");
//		log.getName();
//		String url = "http://eureka-server/test/?param=" + param;
//		return restTemplate.getForObject(url, String.class);
//		System.out.println(environment);
		return "aaaaa";
	}
}
