package com.yxt.yyd.system.api.feigns;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.system.api.fallback.UserFeignFallback;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dimengzhe
 * @date 2021/9/3 22:58
 * @description 用户接口
 * <p>
 * 涉及到注册、获取注册验证码、登录、第三方登录、升级版本、忘记密码、同意隐私政策、第三方登录绑定手机号、
 */
@FeignClient(
        contextId = "system-User",
        name = "yyd-system",
        path = "v1/users",
        fallback = UserFeignFallback.class)
public interface UserFeign {

    /**
     * 获取注册验证码
     *
     * @param mobile 手机号
     * @return
     */
    @ResponseBody
    @PostMapping("/getCode/{mobile}")
    @ApiOperation(value = "获取验证码")
    ResultBean getCode(@ApiParam(value = "手机号", required = true) @PathVariable(value = "mobile", required = true) String mobile);


}
