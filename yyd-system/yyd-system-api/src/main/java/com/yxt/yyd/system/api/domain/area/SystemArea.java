package com.yxt.yyd.system.api.domain.area;

import com.yxt.yyd.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author dimengzhe
 * @Date 2022/6/20 23:29
 * @Description
 */
public class SystemArea extends BaseEntity {
    private static final long serialVersionUID = 1478910590232367531L;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "区划代码")
    private String code;
    @ApiModelProperty(value = "父级sid")
    private String parentSid;
    @ApiModelProperty(value = "级别")
    private Integer level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentSid() {
        return parentSid;
    }

    public void setParentSid(String parentSid) {
        this.parentSid = parentSid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
