package com.yxt.yyd.config;

/**
 * @author dimengzhe
 * @date 2020/12/2 9:58
 * @description 缓存的key 常量
 */

public class CacheConstants {

    /**
     * 令牌自定义标识
     */
    public static final String HEADER = "token";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 用户名字段
     */
    public static final String DETAILS_USERNAME = "userName";

    /**
     * 令牌有效期（分钟）
     */
    public final static long TOKEN_EXPIRE = 4*60;
    public final static long TOKEN_EXPIRE_APP = 15*24*60;
}
