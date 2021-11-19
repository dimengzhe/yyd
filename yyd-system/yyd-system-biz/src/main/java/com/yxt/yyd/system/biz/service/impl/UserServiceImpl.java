package com.yxt.yyd.system.biz.service.impl;

import com.yxt.yyd.common.base.service.MybatisBaseService;
import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.system.api.domain.SystemUser;
import com.yxt.yyd.system.biz.mapper.UserMapper;
import com.yxt.yyd.system.biz.service.IUserSerivce;
import org.springframework.stereotype.Service;

/**
 * @author dimengzhe
 * @date 2021/9/4 0:20
 * @description
 */
@Service
public class UserServiceImpl extends MybatisBaseService<UserMapper, SystemUser> implements IUserSerivce {


    @Override
    public ResultBean getVerificationCode(String mobile, String verificationCode) {
        return null;
    }
}
