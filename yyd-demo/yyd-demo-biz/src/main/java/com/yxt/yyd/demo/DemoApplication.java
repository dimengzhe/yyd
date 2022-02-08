package com.yxt.yyd.demo;

import org.minbox.framework.logging.spring.context.annotation.client.EnableLoggingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
        "com.yxt.yyd.demo"
})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
