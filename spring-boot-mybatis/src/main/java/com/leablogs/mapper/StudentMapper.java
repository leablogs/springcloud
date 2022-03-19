package com.leablogs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.leablogs.bean.Student;

@Mapper
public interface StudentMapper {
	public Student selectStuById(int id);

	public Student selectStuById2(int id);
}
