package com.test.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2021/8/24 3:27 下午
 * @Email: yongye.ysf@raycloud.com
 */
@RestController
public class TestController {

    @GetMapping("/local")
    public String local() {
        return "1";
    }

}
