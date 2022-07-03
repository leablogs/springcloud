package com.leablogs.test.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToUserCoverter implements Converter<String, StringToUserCoverter.User> {

	@Override
	public User convert(String source) {
		User user = new User();
		String[] strings = source.split("-");
		user.setAge(Integer.parseInt(strings[2]));
		user.setId(Integer.parseInt(strings[0]));
		user.setName(strings[1]);
		return user;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	class User{
		private int id;
		private String name;
		private int age;
	}

}
