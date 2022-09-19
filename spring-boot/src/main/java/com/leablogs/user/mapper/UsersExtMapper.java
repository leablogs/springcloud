package com.leablogs.user.mapper;

import com.leablogs.user.entity.UsersExt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author shilh
 * @since 2022-08-11
 */
public interface UsersExtMapper extends BaseMapper<UsersExt> {
    UsersExt getUserById(Integer user_id);
}
