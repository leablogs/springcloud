package com.leablogs.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	@Autowired
	RestTemplate restTemplate;

	public Map<String, String> findAll() {
		return restTemplate.getForObject("http://PANDA-FRAME/user/findAll", Map.class);
	}
}
