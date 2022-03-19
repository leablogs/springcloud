package com.leablogs.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leablogs.bean.Student;
import com.leablogs.bean.StudentCard;
import com.leablogs.mapper.StudentCardMapper;
import com.leablogs.mapper.StudentMapper;
import com.leablogs.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentCardMapper studentMapper;
	@Autowired
	StudentMapper studentMapper2;

	@Override
	public StudentCard selectStuCardById(int id) {
		// TODO Auto-generated method stub
		return studentMapper.selectStuCardById(id);
	}

	@Override
	public Student selectStudById(int id) {
		// TODO Auto-generated method stub
		return studentMapper2.selectStuById(id);
	}

}
