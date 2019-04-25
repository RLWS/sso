package com.rlws.sso.commons.utils;

import java.util.Date;

public class HashUtils {

    private static final int HASH_USER_KEY = 65493462;

    /**
     * 用于生成一个用户ID
     * @return  用户ID
     */
    public static String getUserID(){
        long time = new Date().getTime();
        return (time & HASH_USER_KEY)+"";
    }
}
