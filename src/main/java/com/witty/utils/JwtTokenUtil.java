package com.witty.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtTokenUtil {
    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.expiration}")
    private Long expiration;

    /**
     * 生成token
     * @param username 用户名
     * @return token
     */
    public String generateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    /**
     * 校验token
     * @param token token
     * @return boolean
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 如果token获取用户名
     * @param token token
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        Claims body = Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
        return body.getSubject();
    }

    private Key getSigningKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
