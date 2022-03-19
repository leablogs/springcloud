package com.leablogs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.leablogs.bean.User;
import com.leablogs.bean.UserExt;
import com.leablogs.mapper.UserExtMapper;
import com.leablogs.mapper.UserMapper;
import com.leablogs.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Autowired
	UserExtMapper userExtMapper;

	@Override
	public User getUserByUsernameAndPassword(User user) {
		return userMapper.getByUserNameAndPassword(user);
	}
	// propagation 传播行为
	@Transactional(isolation = Isolation.READ_COMMITTED ,timeout = 1,propagation = Propagation.REQUIRED )
	@Override
	public boolean addUser(User user) {
		try {

			Integer result = userMapper.addUsers(user);

			System.out.println(user.getId());
			UserExt userExt = new UserExt();
			userExt.setMobile("123456789");
			userExt.setSex("male");
			userExt.setUserId(user.getId());
			userExt.setUserId(11);
			userExtMapper.addUserExt(userExt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public String getUserExt() {
		// TODO Auto-generated method stub
		User user = userMapper.getUserAndExt();
		return user.toString();
	}

}
