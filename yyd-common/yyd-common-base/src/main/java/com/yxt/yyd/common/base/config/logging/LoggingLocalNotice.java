package com.yxt.yyd.common.base.config.logging;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.minbox.framework.logging.client.LoggingFactoryBean;
import org.minbox.framework.logging.client.notice.LoggingNotice;
import org.minbox.framework.logging.core.MinBoxLog;
import org.minbox.framework.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author dimengzhe
 * @Date 2022/6/21 11:27
 * @Description 日志模板
 */
@Component
public class LoggingLocalNotice implements LoggingNotice {

    public static final String BEAN_NAME = "loggingLocalNotice";
    static Logger logger = LoggerFactory.getLogger(LoggingLocalNotice.class);
    private final LoggingFactoryBean loggingFactoryBean;

    public LoggingLocalNotice(LoggingFactoryBean loggingFactoryBean) {
        this.loggingFactoryBean = loggingFactoryBean;
    }

    @Override
    public void notice(MinBoxLog minBoxLog) {
        if (this.loggingFactoryBean.isShowConsoleLog()) {
            logger.info("=====接口开始：" + minBoxLog.getRequestUri());
            Log log = new Log();
            if (StringUtils.isNotBlank(minBoxLog.getRequestBody())) {
                JSONObject jsonObject = JSONObject.parseObject(minBoxLog.getRequestBody());
                Map<String, Object> map = JSONObject.parseObject(jsonObject.toJSONString(), new TypeReference<Map<String, Object>>() {
                });
                log.setRequestBodyN(map);
                if (StringUtils.isNotBlank(minBoxLog.getResponseBody())) {
                    jsonObject = JSONObject.parseObject(minBoxLog.getResponseBody());
                    map = JSONObject.parseObject(jsonObject.toJSONString(), new TypeReference<Map<String, Object>>() {
                    });
                    log.setResponseBodyN(map);
                }
            }
            log.setHttpStatus(minBoxLog.getHttpStatus());
            BeanUtil.copyProperties(minBoxLog, log);
//            logger.info("Request Uri：{}， Logging：\n{}", minBoxLog.getRequestUri(), this.loggingFactoryBean.isFormatConsoleLog() ? JsonUtils.beautifyJson(minBoxLog) : JsonUtils.toJsonString(minBoxLog));
            logger.info("Logging：\n{}", this.loggingFactoryBean.isFormatConsoleLog() ? JsonUtils.beautifyJson(log) : JsonUtils.toJsonString(log));
            logger.info("====接口结束");
        }

    }

    @Override
    public int getOrder() {
        return -2147483648;
    }
}
