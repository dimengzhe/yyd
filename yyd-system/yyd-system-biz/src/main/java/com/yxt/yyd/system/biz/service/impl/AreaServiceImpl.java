package com.yxt.yyd.system.biz.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.common.jdbc.service.MybatisBaseService;
import com.yxt.yyd.system.api.domain.area.SystemArea;
import com.yxt.yyd.system.api.domain.area.dto.AreaDto;
import com.yxt.yyd.system.biz.mapper.AreaMapper;
import com.yxt.yyd.system.biz.service.IAreaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Author dimengzhe
 * @Date 2022/6/20 23:36
 * @Description
 */
@Service
public class AreaServiceImpl extends MybatisBaseService<AreaMapper, SystemArea> implements IAreaService {

    @Override
    public ResultBean<String> saveOrUpdate(AreaDto dto) {
        ResultBean<String> rb = ResultBean.fireFail();
        String dtoSid = dto.getSid();
        if (StringUtils.isBlank(dtoSid)) {
            SystemArea systemArea = new SystemArea();
            BeanUtil.copyProperties(dto, systemArea, "sid");
            baseMapper.insert(systemArea);
            dtoSid = systemArea.getSid();
        } else {
            SystemArea systemArea = fetchBySid(dtoSid);
            if (systemArea == null) {
                return rb.setMsg("数据不存在");
            }
            BeanUtil.copyProperties(dto, systemArea);
            baseMapper.updateById(systemArea);
        }
        return rb.success().setData(dtoSid);
    }
}
