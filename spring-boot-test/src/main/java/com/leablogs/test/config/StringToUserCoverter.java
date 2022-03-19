package com.leablogs.test.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.leablogs.pojo.User;

@Component
public class StringToUserCoverter implements Converter<String, User> {

	@Override
	public User convert(String source) {
		User user = new User();
		String[] strings = source.split("-");
		user.setAge(Integer.parseInt(strings[2]));
		user.setId(Integer.parseInt(strings[0]));
		user.setName(strings[1]);
		return user;
	}

}
