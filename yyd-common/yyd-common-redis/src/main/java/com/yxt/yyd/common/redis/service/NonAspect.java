/*
package com.yxt.yyd.common.redis.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

*/
/**
 * @Author dimengzhe
 * @Date 2022/10/9 11:28
 * @Description
 *//*

@Aspect
@Component
public class NonAspect {

    Logger log =  LoggerFactory.getLogger(NonAspect.class);
   */
/* @Resource
    private JedisPool jedisPool;*//*

    @Autowired
    private RedisService redisService;


    @Pointcut("@annotation(com.yxt.yyd.common.redis.service.RepeatSubmit)")
    public void getRepeatSubmit(){};

    @Before(value = "getRepeatSubmit()")
    public void getSubmit(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Jedis jedis = jedisPool.getResource();
            if (redisService.exists(signature.getName())){
                throw new RuntimeException("请勿短时间内重复访问接口!");
            }
            System.out.println(signature.getName());
        redisService.setex(signature.getName(),5,"Cache-"+signature.getName());

    }
}
*/
