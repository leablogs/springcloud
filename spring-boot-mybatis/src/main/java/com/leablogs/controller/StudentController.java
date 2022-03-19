package com.leablogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leablogs.bean.Student;
import com.leablogs.mapper.StudentCardMapper;
import com.leablogs.mapper.StudentMapper;
import com.leablogs.service.StudentService;

//@RestController
public class StudentController {
//	@Autowired
	StudentService studentService;
//	@Autowired
	StudentCardMapper studentCardMapper;

	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public Student name() {
		Student student = studentService.selectStudById(1);
		return student;
	}

	@RequestMapping(value = "/getStudent1", method = RequestMethod.GET)
	public void name1() {
		studentService.selectStuCardById(1);
//		studentCardMapper.students();
	}
}
