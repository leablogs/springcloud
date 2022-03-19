package com.leablogs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.leablogs.bean.TestTwo;
//@Mapper
public interface TestTwoMapper {
	TestTwo getTotalById(Long value);
}
