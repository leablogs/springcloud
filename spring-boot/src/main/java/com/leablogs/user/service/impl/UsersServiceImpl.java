package com.leablogs.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leablogs.user.entity.Users;
import com.leablogs.user.entity.UsersExt;
import com.leablogs.user.mapper.UsersMapper;
import com.leablogs.user.service.IUsersExtService;
import com.leablogs.user.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shilh
 * @since 2022-08-11
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Resource
    private UsersMapper usersMapper;
    @Resource
    private IUsersExtService usersExtService;

    @Override
    public IPage<Users> getListUser(Page<Users> page, short sex) {
        return usersMapper.selectUserByGender(page, sex);
    }

    @Override
    public IPage<Users> pageByGender(Page<Users> page, QueryWrapper<Users> queryWrapper) {

        return usersMapper.selectPage(page, queryWrapper);
    }

    @Override
    public Users getUserById(Integer id) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(Users.class, info -> !info.getColumn().equals("password"));
        return usersMapper.getById(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, readOnly = false, transactionManager = "", timeout = 1)
    public int addUser(Users users) {
        int result = usersMapper.insert(users);
        if (result != 0) {
            UsersExt usersExt = new UsersExt();
            usersExt.setUserId(users.getId());
            usersExt.setProvince("河北省");
            usersExt.setCity("石家庄市");
            usersExt.setArea("新华区");
            usersExtService.insert(usersExt);
        }
        return result;
    }

}
