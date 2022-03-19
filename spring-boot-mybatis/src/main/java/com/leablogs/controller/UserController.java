package com.leablogs.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leablogs.bean.User;
import com.leablogs.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
	public User getUserByUsernameAndPassword() {
		User user = new User();
		user.setUserName("wangjw");
		user.setPassword("123456");
		userService.getUserByUsernameAndPassword(user);
		System.out.println("================");
		return userService.getUserByUsernameAndPassword(user);
	}

	@RequestMapping(value = "addUser", method = RequestMethod.GET)
	public boolean addUser() {
		User user = new User();
		user.setEmail("lixw@qq.com");
		user.setUserId("10");
		user.setPassword("1234566");
		user.setUserName("lix3" + System.currentTimeMillis());
		System.out.println(user.toString());
		return userService.addUser(user);
	}
	@RequestMapping(value = "getUserExt" ,method = RequestMethod.GET)
	public String getUserAndExt() {
		return userService.getUserExt();
	}
}
