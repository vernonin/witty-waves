package com.witty.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtils {

    // 密码加密
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
