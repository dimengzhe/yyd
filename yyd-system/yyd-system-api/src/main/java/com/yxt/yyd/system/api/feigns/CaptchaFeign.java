package com.yxt.yyd.system.api.feigns;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.system.api.fallback.CaptchaFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author dimengzhe
 * @date 2021/9/3 17:33
 * @description 验证码
 */
@FeignClient(
        contextId = "yxt-yyd-system-Captcha",
        name = "yxt-yyd-system",
        path = "v1/captchas",
        fallback = CaptchaFeignFallback.class)
public interface CaptchaFeign {

    @GetMapping("/captchaImage")
    @ResponseBody
    ResultBean getCode(HttpServletResponse response);
}
