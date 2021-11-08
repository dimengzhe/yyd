package com.yxt.yyd.system.biz.controller;

import com.yxt.yyd.system.api.feigns.CaptchaFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dimengzhe
 * @date 2021/9/3 17:46
 * @description 验证码
 */
@Controller
@RequestMapping("v1/captchas")
public class CaptchaController implements CaptchaFeign {


}
