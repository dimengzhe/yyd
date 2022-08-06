package com.yxt.yyd.system.api.feigns;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.system.api.domain.area.SystemAreaDto;
import com.yxt.yyd.system.api.fallback.AreaFeignFallback;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author dimengzhe
 * @Date 2022/6/20 22:51
 * @Description 区域管理接口
 */
@Api(tags = "区域管理接口")
@FeignClient(
        contextId = "system-area",
        name = "yyd-system",
        path = "v1/area",
        fallback = AreaFeignFallback.class)
public interface AreaFeign {
    /**
     * 区域保存
     *
     * @param dto 区域保存参数
     * @return
     */
    @ApiOperation(value = "区域-保存")
    @ResponseBody
    @PostMapping(value = "saveOrUpdate")
    ResultBean<String> saveOrUpdate(@RequestBody SystemAreaDto dto);
}
