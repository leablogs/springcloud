package com.leablogs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.leablogs.bean.UserExt;

@Mapper
public interface UserExtMapper {
	public boolean addUserExt(UserExt userExt);
}
