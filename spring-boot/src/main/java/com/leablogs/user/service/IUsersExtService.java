package com.leablogs.user.service;

import com.leablogs.user.entity.UsersExt;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shilh
 * @since 2022-08-11
 */
public interface IUsersExtService extends IService<UsersExt> {
    int insert(UsersExt usersExt);

    UsersExt getUserByid(Integer user_id);
}
