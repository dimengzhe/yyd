package com.yxt.yyd.system;

import org.minbox.framework.logging.spring.context.annotation.client.EnableLoggingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dimengzhe
 * @date 2020/9/11 14:44
 * @description
 */
@EnableDiscoveryClient
@EnableLoggingClient
@SpringBootApplication(scanBasePackages = {
        "com.yxt.yyd.common.redis",
        "com.yxt.yyd.common.base.config",
        "com.yxt.yyd.common.jdbc.config",
        "com.yxt.yyd.system"
})
@EnableFeignClients  //开启Feign客户端功能
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

}
