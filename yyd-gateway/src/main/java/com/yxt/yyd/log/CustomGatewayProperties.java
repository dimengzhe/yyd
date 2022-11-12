package com.yxt.yyd.log;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @Author dimengzhe
 * @Date 2022/11/7 0:00
 * @Description
 */
@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "spring.cloud.gateway")
public class CustomGatewayProperties {

    /**
     * 请求日志
     */
    private Boolean requestLog;
}
