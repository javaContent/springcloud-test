package com.test.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/4 11:49 上午
 * @Email: yongye.ysf@raycloud.com
 */
@RestController
public class ErrorController {

    @GetMapping("/error/403")
    public String error403() {
        return "页面没有访问权限";
    }

    @GetMapping("/error/404")
    public String error404() {
        return "页面没有找到";
    }
}
