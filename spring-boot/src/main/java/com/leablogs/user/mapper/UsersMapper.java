package com.leablogs.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leablogs.user.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author shilh
 * @since 2022-08-11
 */
public interface UsersMapper extends BaseMapper<Users> {
    IPage<Users> selectUserByGender(Page<Users> page, @Param("sex") short sex);

    IPage<Users> selectPage(Page<Users> page, QueryWrapper<Users> queryWrapper);

    Users getById(Integer id);
}
