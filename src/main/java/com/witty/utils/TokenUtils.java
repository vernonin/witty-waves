package com.witty.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.witty.entity.User;
import lombok.val;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private static final String secretKey = "^^witty_waves__";
    private static final Integer expiresTime = 1000 * 60 * 60;

    /**
     * 生成token
     * @param user 用户实体
     * @return token
     */
    public static String getToken(User user) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiresTime))
                .withIssuer(user.getUsername())
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("name", user.getName())
                .withClaim("email", user.getEmail())
                .sign(Algorithm.HMAC256(secretKey));
    }

    /**
     * 解析token
     * @param token token
     * @return map
     */
    public static Map<String, String> parseToken(String token) {
        HashMap<String, String> info = new HashMap<>();

        DecodedJWT verify = JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
        info.put("id", verify.getClaim("id").asInt().toString());
        info.put("username", verify.getClaim("username").asString());
        info.put("name", verify.getClaim("name").asString());
        info.put("email", verify.getClaim("email").asString());

        return info;
    }
}
