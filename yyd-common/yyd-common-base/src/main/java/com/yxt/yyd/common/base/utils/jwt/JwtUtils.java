package com.yxt.yyd.common.base.utils.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author dimengzhe
 * @Date 2021/11/6 22:55
 * @Description
 */
public class JwtUtils {

    /**
     * 签名密钥（高度保密）
     */
    private static final String SECRET = "qYYjXt7s1C*nEC%9RCwQGFA$YwPr$Jrj";
    /**
     * 签名算法
     */
    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
    /**
     * token前缀
     */
    private static final String TOKEN_PREFIX = "Bearer ";
    /**
     * 有效期：1天
     */
    private static final Long TIME = 24 * 3600 * 1000L;

    /**
     * 生成JWT token
     *
     * @param map 传入数据
     * @return
     */
    public static String sign(Map<String, Object> map) {
        Date now = new Date(System.currentTimeMillis());
        String jwt = Jwts.builder()
                // 设置自定义数据
                .setClaims(map)
                // 设置签发时间
                .setIssuedAt(now)
                // 设置过期时间
                .setExpiration(new Date(now.getTime() + TIME))
                .signWith(SIGNATURE_ALGORITHM, SECRET)
                .compact();
        return TOKEN_PREFIX + jwt;
    }

    /**
     * 验证JWT token并返回数据。当验证失败时，抛出异常
     *
     * @param token token
     * @return
     */
    public static Map unSign(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
        } catch (Exception e) {
            throw new IllegalStateException("Token验证失败：" + e.getMessage());
        }
    }

    public static void main(String[] args) {
      /*  Map<String, Object> map = new HashMap<>();
        map.put("userName", "admin");
        map.put("userId", "001");
        String token = JwtUtils.sign(map, 3600_000);
        System.out.println(JwtUtils.unSign(token));*/
        Map<String, Object> map = new HashMap<>();
        map.put("userSid", "123456788");
        map.put("userName", "你好");
//        sign(map);
//        System.out.println(sign(map));
        Map<String,Object> map1 = unSign("Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyU2lkIjoiMTIzNDU2Nzg4IiwidXNlck5hbWUiOiLkvaDlpb0iLCJleHAiOjE2MzYyOTk0NTgsImlhdCI6MTYzNjIxMzA1OH0.iuyZznSCm0QYneqfck_zc3fpg57YsAdG8k2aLrDY_4NZJwJdVxE7supqLtfEvTC5O0EhG590ShhRsVoU-rbSrA");
        System.out.println(map1);
    }
}
