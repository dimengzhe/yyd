package com.yxt.yyd.demo.biz.controller;

import com.yxt.yyd.demo.api.domain.Address;
import com.yxt.yyd.demo.api.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author dimengzhe
 * @Date 2022/1/29 0:36
 * @Description
 */
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    public String getCity(User user){
        if (user != null) {
            if (user.getAddress() != null) {
                Address address = user.getAddress();
                if (address.getCity() != null) {
                    return address.getCity();
                }
            }
        }
        logger.error("取值错误");
        return "";
    }

//    public String getCityOne(User user) throws Exception {
//        return Optional.ofNullable(user)
//                .map(u -> u.getAddress())
//                .map(a -> a.getCity())
//                .orElseThrow(() -> new Exception("取指错误"));
//    }
}
