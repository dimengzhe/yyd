package com.yxt.yyd.system.biz.controller;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.common.utils.ValidationUtil;
import com.yxt.yyd.system.api.domain.area.AreaDto;
import com.yxt.yyd.system.api.feigns.AreaFeign;
import com.yxt.yyd.system.biz.service.IAreaService;
import org.apache.commons.lang3.StringUtils;
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
    public ResultBean<String> saveOrUpdate(AreaDto dto) {
       ResultBean rb = ResultBean.fireFail();
        String errorMsg = ValidationUtil.validateOne(dto);
        if (StringUtils.isNotBlank(errorMsg)) {
            return rb.setMsg(errorMsg);
        }
        return areaService.saveOrUpdate(dto);
    }
}
