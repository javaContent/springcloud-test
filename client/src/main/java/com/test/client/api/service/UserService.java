package com.test.client.api.service;


import com.test.client.api.service.fallback.UserFallBack;
import com.test.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user-service", fallback = UserFallBack.class)
public interface UserService {

    @GetMapping("/user/selectOne")
    public User selectOne(Long id);

    @GetMapping("/test")
    public String test();

}
