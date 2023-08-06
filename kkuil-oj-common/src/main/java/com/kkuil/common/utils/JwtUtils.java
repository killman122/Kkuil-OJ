package com.kkuil.common.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/08/05 12:30
 * @Description Jwt工具类
 */
public class JwtUtils {
    /**
     * @param data Map<String, Object>
     * @return String
     * @description 生成token
     */
    public static String create(Map<String, Object> data, String secret, long ttl) {
        try {
            return Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .setClaims(data)
                    .setExpiration(new Date(System.currentTimeMillis() + ttl))
                    .compact();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param token String
     * @return String
     * @description 解析token
     */
    public static Claims parse(String token, String secret) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException |
                 IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

}
