package com.yxt.yyd.system.api.fallback;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.system.api.domain.area.AreaDto;
import com.yxt.yyd.system.api.feigns.AreaFeign;
import org.springframework.stereotype.Component;

/**
 * @Author dimengzhe
 * @Date 2022/6/20 22:59
 * @Description 容错处理
 */
@Component
public class AreaFeignFallback implements AreaFeign {
    @Override
    public ResultBean saveOrUpdate(AreaDto dto) {
        ResultBean rb = ResultBean.fireFail();
        return rb.setMsg("区域保存:/v1/area/save访问出错");
    }
}
