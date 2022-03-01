package com.leablogs.service;

import com.leablogs.bean.User;

public interface UserService {
	public User getUserByUsernameAndPassword(User user);
	public boolean addUser(User user);
}
