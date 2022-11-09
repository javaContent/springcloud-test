package com.test.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/4 11:49 上午
 * @Email: yongye.ysf@raycloud.com
 */
@RestController
public class MemberController {

    @GetMapping("/addMember")
    public String addMember() {
        return "addMember";
    }

    @GetMapping("/delMember")
    public String delMember() {
        return "delMember";
    }

    @GetMapping("/getMember")
    public String getMember() {
        return "getMember";
    }

}
