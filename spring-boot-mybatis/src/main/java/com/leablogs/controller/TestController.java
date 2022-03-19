package com.leablogs.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leablogs.annotation.SystemLogs;
import com.leablogs.bean.TestOne;
import com.leablogs.bean.TestTwo;
import com.leablogs.mapper.TestOneMapper;
import com.leablogs.mapper.TestTwoMapper;

@RestController
public class TestController {
	@Autowired
	private TestOneMapper testOneMapper;
	@Autowired
	private TestTwoMapper testTwoMapper;

	@RequestMapping(value = "/getAllOne", method = RequestMethod.GET)
	@SystemLogs
	public TestOne getAllOne() {
		return testOneMapper.getTotalById(1L);
	}

	@RequestMapping(value = "/getAllTwo", method = RequestMethod.GET)
	public TestTwo getAllTwo() {
		return testTwoMapper.getTotalById(1L);
	}

	@RequestMapping(value = "/getOneByage", method = RequestMethod.GET)
	public List<TestOne> getOneByAge() {
		List<Integer> ageList = new ArrayList<Integer>();
		ageList.add(1);
		ageList.add(2);
		PageHelper.startPage(1, 20, false);
		List<TestOne> testOnes = testOneMapper.selectOneByAgeId(ageList);
		System.out.println("list size: " + testOnes.size());
		PageInfo pageInfo = new PageInfo(testOnes);
		
		System.out.println("pages: " + pageInfo.getPages());
		System.out.println("page size: " + pageInfo.getPageSize());
		System.out.println("end row: " + pageInfo.getEndRow());
		System.out.println("next page: " + pageInfo.getNextPage());
		System.out.println("total: " + pageInfo.getTotal());
//		return testOneMapper.selectOneByAgeId(ageList);
		return pageInfo.getList();
	}

	@RequestMapping(value = "/getOneBykeyword", method = RequestMethod.GET)
	public List<TestOne> getOneBykeyword() {
		return testOneMapper.selectOneByKey("w");
	}

	@RequestMapping(value = "/getOneBykeyword1", method = RequestMethod.GET)
	public List<TestOne> getOneBykeyword1() {

		return testOneMapper.selectOneBykeyOr("w", null);
	}
}
