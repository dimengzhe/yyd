package com.yxt.yyd.common.core.result;

import com.yxt.yyd.common.core.constant.Constants;

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

    public static <T> ResultBean<T> success() {
        return restResult(null, SUCCESS, null, true);
    }

    public static <T> ResultBean<T> success(T data) {
        return restResult(data, SUCCESS, null, true);
    }

    public static <T> ResultBean<T> success(T data, String msg) {
        return restResult(data, SUCCESS, msg, true);
    }

    public static <T> ResultBean<T> fail() {
        return restResult(null, FAIL, null, false);
    }

    public static <T> ResultBean<T> fail(String msg) {
        return restResult(null, FAIL, msg, false);
    }

    public static <T> ResultBean<T> fail(T data) {
        return restResult(data, FAIL, null, false);
    }

    public static <T> ResultBean<T> fail(T data, String msg) {
        return restResult(data, FAIL, msg, false);
    }

    public static <T> ResultBean<T> fail(int code, String msg) {
        return restResult(null, code, msg, false);
    }

    private static <T> ResultBean<T> restResult(T data, int code, String msg, Boolean success) {
        ResultBean<T> apiResult = new ResultBean<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        apiResult.setSuccess(success);
        return apiResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
