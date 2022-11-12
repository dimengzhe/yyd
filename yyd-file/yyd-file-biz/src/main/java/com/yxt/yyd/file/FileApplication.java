package com.yxt.yyd.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dimengzhe
 * @date 2020/9/11 14:44
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "com.yxt.yyd.file"
})
public class FileApplication {


    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }

}
