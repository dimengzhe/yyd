package com.yxt.yyd.system;

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
        "com.yxt.yyd.common.utils",
        "com.yxt.yyd.common.base.config",
        "com.yxt.yyd.pay"
})
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
