package com.yxt.yyd.system.api.feigns;

import com.yxt.yyd.system.api.fallback.CaptchaFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author dimengzhe
 * @date 2021/9/3 17:33
 * @description 验证码
 */
@FeignClient(
        contextId = "system-Captcha",
        name = "yyd-system",
        path = "v1/captchas",
        fallback = CaptchaFeignFallback.class)
public interface CaptchaFeign {






}
