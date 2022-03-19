package com.leablogs.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.leablogs.security.pojo.User;
import com.leablogs.security.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User findByname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User insert(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	// 返回认证用户信息对象
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByname(username);
		if (user == null) {
			return null;
		}
		return user;
	}

}
