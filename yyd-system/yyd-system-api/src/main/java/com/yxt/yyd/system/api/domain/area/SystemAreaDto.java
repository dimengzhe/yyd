package com.yxt.yyd.system.api.domain.area;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author dimengzhe
 * @Date 2022/6/20 23:00
 * @Description 区域-保存
 */
public class SystemAreaDto implements Serializable {

    private static final long serialVersionUID = -5321692236199323442L;

    @ApiModelProperty(value = "名称")
    @NotBlank(message = "名称不能为空")
    private String name;
    @ApiModelProperty(value = "区划代码")
    private String code;
    @ApiModelProperty(value = "父级sid", example = "0")
    private String parentSid;
    @ApiModelProperty(value = "级别")
    private Integer level;

    @ApiModelProperty(value = "省sid:修改时传，新增时不传", required = false)
    private String sid;

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

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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
