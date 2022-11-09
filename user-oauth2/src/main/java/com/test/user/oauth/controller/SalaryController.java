package com.test.user.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/8 3:46 下午
 * @Email: yongye.ysf@raycloud.com
 */
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @GetMapping("/test")
    public String test() {
        return "OrderController";
    }


}
