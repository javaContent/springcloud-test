package com.test.client.controller;

import com.test.client.api.service.UserService;
import com.test.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2021/8/24 3:27 下午
 * @Email: yongye.ysf@raycloud.com
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User selectOne(Long id) {
        return userService.selectOne(id);
    }

    @GetMapping("/test1")
    public String test1() {
        return userService.test();
    }

    @GetMapping("/local")
    public String local() {
        return "2";
    }
}
