package com.test.client.api.service.fallback;

import com.test.client.api.service.UserService;
import com.test.user.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2021/8/24 3:38 下午
 * @Email: yongye.ysf@raycloud.com
 */
@Component
public class UserFallBack implements UserService {

    @Override
    public User selectOne(Long id) {
        return new User();
    }

    @Override
    public String test() {
        return "fegin调用失败！";
    }
}
