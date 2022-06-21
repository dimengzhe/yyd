package com.yxt.yyd.common.base.config.logging;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author dimengzhe
 * @Date 2022/6/21 15:48
 * @Description
 */
public class Log implements Serializable {

    private static final long serialVersionUID = 3958980733637576088L;
    private String serviceId;
    private String requestIp;
    private String serviceIp;
    private String servicePort;
    private Integer httpStatus;
    private String requestMethod;
    private String requestUri;

    private Map<String, Object> requestBodyN;
    private Map<String, Object> responseBodyN;

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp;
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Map<String, Object> getRequestBodyN() {
        return requestBodyN;
    }

    public void setRequestBodyN(Map<String, Object> requestBodyN) {
        this.requestBodyN = requestBodyN;
    }

    public Map<String, Object> getResponseBodyN() {
        return responseBodyN;
    }

    public void setResponseBodyN(Map<String, Object> responseBodyN) {
        this.responseBodyN = responseBodyN;
    }
}
