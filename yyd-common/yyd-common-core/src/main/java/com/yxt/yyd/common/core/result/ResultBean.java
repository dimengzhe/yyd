package com.yxt.yyd.common.core.result;

import com.yxt.yyd.common.core.constant.Constants;
import com.yxt.yyd.common.core.constant.HttpStatus;

import java.io.Serializable;

/**
 * @Author dimengzhe
 * @Date 2021/8/23 16:42
 * @Description 返回结果
 */
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = Constants.SUCCESS;

    /**
     * 失败
     */
    public static final int FAIL = Constants.FAIL;

    private int code;

    private String msg;

    private T data;
    private Boolean success;

    public ResultBean() {
    }

    public ResultBean(boolean success) {
        this.success = success;
    }

    public ResultBean(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ResultBean(boolean success, String msg, int code) {
        this.success = success;
        this.msg = msg;
        this.code = code;
    }

    public ResultBean(T data) {
        this.success = true;
        this.data = data;
    }

    public ResultBean(int code, T data) {
        this.success = true;
        this.code = code;
        this.data = data;
    }

    public ResultBean(int code, String msg, T data) {
        this.success = true;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public ResultBean<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultBean<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResultBean<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultBean<T> setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * 1.类实例化的非静态方法调用 2.类不实例化的静态方法调用
     *
     * @return
     */
    public ResultBean<T> success() {
        this.setSuccess(true);
        this.setCode(HttpStatus.SUCCESS);
        this.setMsg("操作成功！");
        return this;
    }

    public ResultBean<T> fail() {
        this.setSuccess(false);
        this.setCode(HttpStatus.ERROR);
        this.setMsg("操作失败！");
        return this;
    }

    public static <T> ResultBean<T> fireSuccess() {
        ResultBean<T> rb = new ResultBean<T>();
        rb.setSuccess(true);
        rb.setCode(HttpStatus.SUCCESS);
        rb.setMsg("操作成功！");
        return rb;
    }

    public static <T> ResultBean<T> fireFail() {
        ResultBean<T> rb = new ResultBean<T>();
        rb.setSuccess(false);
        rb.setCode(HttpStatus.ERROR);
        rb.setMsg("操作失败！");
        return rb;
    }

}
