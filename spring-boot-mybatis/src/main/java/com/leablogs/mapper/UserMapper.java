package com.leablogs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.leablogs.bean.User;

@Mapper
public interface UserMapper {
	User getByUserNameAndPassword(User user);

	Boolean addUsers(User user);

//	List<User> getAllUsers();
}
