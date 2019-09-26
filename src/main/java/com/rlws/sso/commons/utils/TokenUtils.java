package com.rlws.sso.commons.utils;

import java.util.Random;

public class TokenUtils {

    private static String token = "";

    private static void productToken(){
        String timer = System.currentTimeMillis()+new Random().nextInt()+"";
        token = MD5Utils.encode(timer);
    }

    public static String getToken(){
        productToken();
        return token;
    }
}
