package com.yxt.yyd.system.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dimengzhe
 * @date 2021/11/3 23:30
 * @description
 */
@SpringBootApplication(scanBasePackages = {
        "com.yxt.yyd.common.utils",
        "com.yxt.yyd.common.base.config",
        "com.yxt.yyd.system"
})
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
