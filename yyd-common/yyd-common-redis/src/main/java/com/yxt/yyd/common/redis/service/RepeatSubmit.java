package com.yxt.yyd.common.redis.service;

import java.lang.annotation.*;

/**
 * @Author dimengzhe
 * @Date 2022/10/9 11:28
 * @Description
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {
}
