package com.yxt.yyd.system.biz.service;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.system.api.domain.area.SystemAreaDto;

/**
 * @Author dimengzhe
 * @Date 2022/6/20 23:36
 * @Description
 */
public interface IAreaService {
    ResultBean<String> saveOrUpdate(SystemAreaDto dto);
}
