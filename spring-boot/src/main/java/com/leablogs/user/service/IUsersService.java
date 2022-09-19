package com.leablogs.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leablogs.user.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shilh
 * @since 2022-08-11
 */
public interface IUsersService extends IService<Users> {
    IPage<Users> getListUser(Page<Users> page, short sex);

    IPage<Users> pageByGender(Page<Users> page, QueryWrapper<Users> queryWrapper);

    Users getUserById(Integer id);

    int addUser(Users users);

}
