package com.leablogs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@RequestMapping(value = "/getUserList",method = RequestMethod.GET)
//	@GetMapping("/getUserList")
	public List<String> getUserList() {
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("shilh");
		arrayList.add("wangjw");
		arrayList.add("masg");
		return arrayList;
	}
}
