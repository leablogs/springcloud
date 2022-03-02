package com.leablogs.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.leablogs.bean.User;
import com.leablogs.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {
	@Cacheable(cacheNames = "user", key = "#id")
	@Override
	public User selectById(String id) {
		// TODO Auto-generated method stub

		User user = new User();
		user.setEmail("wang@wwq.com");
		user.setUserName("wang");
		user.setUserId(id);
		return user;
	}

}
