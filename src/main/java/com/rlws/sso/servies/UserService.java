package com.rlws.sso.servies;

import com.rlws.sso.entity.User;

public interface UserService {

    /**
     * 根据邮箱获取用户详情
     * @param email
     * @return
     */
    User selectByEmail(String email , String pwd);
}
