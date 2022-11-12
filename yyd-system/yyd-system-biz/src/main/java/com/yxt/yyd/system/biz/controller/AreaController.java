package com.yxt.yyd.system.biz.controller;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.common.redis.service.RepeatSubmit;
import com.yxt.yyd.system.api.domain.area.SystemAreaDto;
import com.yxt.yyd.system.api.feigns.AreaFeign;
import com.yxt.yyd.system.biz.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author dimengzhe
 * @Date 2022/6/20 23:35
 * @Description
 */
@Controller
@RequestMapping(value = "v1/area")
public class AreaController implements AreaFeign {

    @Autowired
    private IAreaService areaService;

    @Override
    @RepeatSubmit
    public ResultBean<String> saveOrUpdate(SystemAreaDto dto) {
        ResultBean rb = ResultBean.fireFail();
        /*String errorMsg = ValidationUtil.validateOne(dto);
        if (StringUtils.isNotBlank(errorMsg)) {
            return rb.setMsg(errorMsg);
        }*/
        return areaService.saveOrUpdate(dto);
    }
}
