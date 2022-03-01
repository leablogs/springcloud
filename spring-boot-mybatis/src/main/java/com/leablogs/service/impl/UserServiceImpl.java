package com.leablogs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leablogs.bean.User;
import com.leablogs.mapper.UserMapper;
import com.leablogs.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public User getUserByUsernameAndPassword(User user) {
		return userMapper.getByUserNameAndPassword(user);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUsers(user);
	}

}
