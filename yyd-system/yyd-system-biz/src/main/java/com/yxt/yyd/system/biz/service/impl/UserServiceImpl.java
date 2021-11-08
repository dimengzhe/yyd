package com.yxt.yyd.system.biz.service.impl;

import com.yxt.yyd.common.base.service.MybatisBaseService;
import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.common.utils.service.RedisService;
import com.yxt.yyd.system.api.domain.SystemUser;
import com.yxt.yyd.system.biz.mapper.UserMapper;
import com.yxt.yyd.system.biz.service.IUserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;

/**
 * @author dimengzhe
 * @date 2021/9/4 0:20
 * @description
 */
@Service
public class UserServiceImpl implements IUserSerivce {



}
