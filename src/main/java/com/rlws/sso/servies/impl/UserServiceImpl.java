package com.rlws.sso.servies.impl;

import com.rlws.sso.commons.utils.MD5Utils;
import com.rlws.sso.commons.utils.RedisUtils;
import com.rlws.sso.entity.User;
import com.rlws.sso.mapper.UserMapper;
import com.rlws.sso.servies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByEmail(String email , String pwd) {
        User user = userMapper.selectByEmail(email);
        if (user != null){
            String MD5Pwd = MD5Utils.encode(pwd);
            if (MD5Pwd.equals(user.getPassword())){
                //addUserDataToRedis(user,MD5Pwd);
                return user;
            }
        }
        return null;
    }


}
