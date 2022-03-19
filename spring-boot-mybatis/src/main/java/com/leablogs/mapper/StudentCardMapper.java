package com.leablogs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.leablogs.bean.Student;
import com.leablogs.bean.StudentCard;
@Mapper
public interface StudentCardMapper {
	public StudentCard selectStuCardById(int id);
	
	public List<Student> students();
}
