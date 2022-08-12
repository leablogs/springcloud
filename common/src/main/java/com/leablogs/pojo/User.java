package com.leablogs.pojo;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude = { "id", "name", "age" })
@EqualsAndHashCode(exclude = { "id", "name", "age" })
@RequiredArgsConstructor
public class User {
	@NotNull(message = "id 不能为空")
	private int id;
	@NotNull(message = "name 不能为空")
	private String name;

	@NotNull
	@Size(min = 0, max = 120,message = "年龄的范围应该在0-120岁之间")
	private int age;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date date;

	private Boolean delete;

	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
}
