package com.leablogs.service;

import java.util.Map;

import com.leablogs.bean.Student;
import com.leablogs.bean.StudentCard;

public interface StudentService {
	public StudentCard selectStuCardById(int id);
	
	public Student selectStudById(int id);
}
