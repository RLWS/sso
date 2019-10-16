package com.rlws.sso.commons.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rlws.sso.entity.User;

public class TokenUtils {

    public static String getToken(User user) {
        String token = "";
        String s = JSON.toJSONString(user);
        System.out.println(s);
        token = JWT.create().withAudience(s).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
