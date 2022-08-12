package com.leablogs.user.service.impl;

import com.leablogs.user.entity.Users;
import com.leablogs.user.mapper.UsersMapper;
import com.leablogs.user.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shilh
 * @since 2022-08-11
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
