package com.test.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/13 9:05 下午
 * @Email: yongye.ysf@raycloud.com
 */
@RestController
public class TestConfig {

    @Value("${javaee.name}")
    private String name;

    @GetMapping("/test")
    public String test() {
        return "name:" + name;
    }
}
