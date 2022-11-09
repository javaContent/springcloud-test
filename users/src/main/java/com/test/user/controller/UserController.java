package com.test.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.user.entity.User;
import com.test.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户信息表(User)表控制层
 *
 * @author makejava
 * @since 2021-08-24 18:00:44
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @HystrixCommand(fallbackMethod = "getFallback")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

    private User getFallback(Long id) {
        User user = new User();
        user.setId(-9999L);
        user.setAccount("null");
        return user;
    }

}
