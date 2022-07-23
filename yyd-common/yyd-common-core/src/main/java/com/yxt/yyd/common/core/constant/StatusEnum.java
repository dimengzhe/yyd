package com.yxt.yyd.common.core.constant;

/**
 * @Author dimengzhe
 * @Date 2022/7/23 22:37
 * @Description
 */
public enum StatusEnum {
    /**
     * 状态分类
     */
    SUCCESS(200, "成功"),
    FAIL(500, "失败"),
    OVERDUE(5000, "登录状态已过期");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

    StatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
