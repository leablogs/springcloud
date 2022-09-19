package com.leablogs.user.service.impl;

import com.leablogs.user.entity.UsersExt;
import com.leablogs.user.mapper.UsersExtMapper;
import com.leablogs.user.service.IUsersExtService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class UsersExtServiceImpl extends ServiceImpl<UsersExtMapper, UsersExt> implements IUsersExtService {
    @Resource
    UsersExtMapper usersExtMapper;

    public int insert(UsersExt usersExt) {
        return usersExtMapper.insert(usersExt);
    }

    public UsersExt getUserByid(Integer user_id) {
        return usersExtMapper.getUserById(user_id);
    }
}
