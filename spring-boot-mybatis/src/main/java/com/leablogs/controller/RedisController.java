package com.leablogs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leablogs.bean.User;
import com.leablogs.service.RedisService;
import com.leablogs.service.UserService;
import com.leablogs.util.RedisUtil;

@RestController
public class RedisController {
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "getString", method = RequestMethod.GET)
	public Object getString() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "shilh");
		map.put("address", "shijiazhuang");
		redisUtil.set("r", map);
		return redisUtil.get("r");
	}

	@RequestMapping(value = "getById", method = RequestMethod.GET)
	public User getById() {
		
		return redisService.selectById("34");
	}

}
