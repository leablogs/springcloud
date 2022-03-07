package com.leablogs.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {
	@Autowired
	RestTemplate restTemplate;

	public Map<String, String> findAll() {
		return restTemplate.getForObject("http://PANDA-FRAME/user/findAll", Map.class);
//		return restTemplate.postForObject("http://PANDA-FRAME/user/findAll","", Map.class);
//		restTemplate.delete("http://PANDA-FRAME/user/findAll");
//		return restTemplate.put("http://PANDA-FRAME/user/findAll", Map.class);
//		return restTemplate.getForObject("http://PANDA-FRAME/user/findAll", Map.class);
//		return restTemplate.getForObject("http://PANDA-FRAME/user/findAll", Map.class);
	}
	
	@HystrixCommand(fallbackMethod = "helloFallBack")
	public String helloService() {
		return restTemplate.getForObject("http://PANDA-FRAME/hello",String.class);
	}
	
	public String helloFallBack() {
		return "error";
	}
}
