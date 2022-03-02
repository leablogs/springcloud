package com.leablogs.service;

import com.leablogs.bean.User;

public interface RedisService {
	public User selectById(String id);
}
