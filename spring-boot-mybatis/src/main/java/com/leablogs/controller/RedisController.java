package com.leablogs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leablogs.bean.User;
import com.leablogs.service.UserService;

@RestController
public class RedisController {
	private 
	@RequestMapping(value = "getString", method = RequestMethod.GET)
	public String getString() {
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", "shilh");
		map.put("address", "shijiazhuang");
		redisha
		return "shilh";
	}

}
