package com.yxt.yyd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dimengzhe
 * @date 2020/8/28 14:11
 * @description 网关
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class YydGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(YydGatewayApplication.class, args);
        log.info("------Gateway Running------");
    }
}
