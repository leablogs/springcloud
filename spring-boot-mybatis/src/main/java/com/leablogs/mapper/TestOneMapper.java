package com.leablogs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.leablogs.bean.TestOne;

//@Mapper
public interface TestOneMapper {
	public TestOne getTotalById(Long value);

	public List<TestOne> selectOneByAgeId(List<Integer> ageList);

	public List<TestOne> selectOneByKey(String name);

	public List<TestOne> selectOneBykeyOr(@Param ("nickname") String nickname, @Param("rank") String rank);
}
