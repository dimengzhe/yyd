package com.yxt.yyd.common.base.config.handler;

import com.yxt.yyd.common.core.result.ResultBean;

/**
 * @Author dimengzhe
 * @Date 2022/5/13 17:23
 * @Description
 */
public class CustomException extends Exception {

    private static final long serialVersionUID = 1L;


    public CustomException() {
        super();
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     */
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public CustomException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public CustomException(Throwable cause) {
        super(cause);
    }

}
