package com.leablogs.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.leablogs.security.pojo.User;

public interface UserService extends UserDetailsService {
	User findByname(String name);

	User insert(User user);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
