package com.leablogs.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leablogs.pojo.User;

@RestController
public class BeanController {
	@Value("${server.port}")
	private int port;
	@Autowired
	private Environment env;

	@RequestMapping("/getIntergal")
	public Integer getIntergal() {
		System.out.println(env);
		return port;
	}

	@RequestMapping("/requestArr")
	@ResponseBody
	public Map<String, Object> requestArr(int[] intArr, Long[] longArr, String[] strArr) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("intArr", intArr);
		paraMap.put("longArr", longArr);
		paraMap.put("strArr", strArr);
		return paraMap;
	}

	@RequestMapping(value = "/{id}")
	public long getPathParam(@PathVariable("id") long id) {
		return id;
	}

	@RequestMapping(value = "/customParams")
	public User getPathParam(@Valid User user) {
		return user;
	}
}
