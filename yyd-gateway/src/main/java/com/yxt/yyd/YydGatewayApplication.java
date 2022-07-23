package com.yxt.yyd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author dimengzhe
 * @date 2020/8/28 14:11
 * @description 网关
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//不加载数据源
@Slf4j
public class YydGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(YydGatewayApplication.class, args);
        log.info("------" + LocalDate.now(), LocalTime.now() + "------");
        log.info("(♥◠‿◠)ﾉﾞ  网关模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
