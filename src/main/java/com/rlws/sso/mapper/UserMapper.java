package com.rlws.sso.mapper;

import com.rlws.sso.entity.User;

public interface UserMapper {

    /**
     * 根据邮箱获取用户详情
     * @param email
     * @return
     */
    User selectByEmail(String email);

}
