package com.leablogs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@RequestMapping(value = "/user/findAll1", method = RequestMethod.GET)
	public Map<String, String> getUsername() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "shilh");
		map.put("address", "shijiazhuang");
		System.err.println("------------");

		return map;
	}
}
