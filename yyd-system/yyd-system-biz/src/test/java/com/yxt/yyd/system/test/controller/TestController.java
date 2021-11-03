package com.yxt.yyd.system.test.controller;

import org.minbox.framework.logging.client.global.GlobalLogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dimengzhe
 * @date 2021/11/3 23:31
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private GlobalLogging logging;

    @GetMapping("/testGet1")
    public String testGet1(@RequestParam("name") String name, @RequestParam("age") Integer age) {

        try {
            int a = 5 / 0;
        } catch (Exception e) {
            logging.error(e.getMessage(), e);
        }
        return "testGet1:  name is " + name + " and  age is :" + age;


    }

    @PostMapping("/testPost2")
    public String testPost2(String name, String age) {
        return name + age;
    }

}
