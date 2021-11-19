package com.yxt.yyd.system.biz.controller;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.system.api.feigns.UserFeign;
import org.springframework.stereotype.Controller;

/**
 * @author dimengzhe
 * @date 2021/9/4 0:11
 * @description 用户管理
 */
@Controller
public class UserController implements UserFeign {

    @Override
    public ResultBean getCode(String mobile) {
        return null;
    }
}
