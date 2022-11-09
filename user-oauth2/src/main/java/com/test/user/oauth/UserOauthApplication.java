package com.test.user.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/8 3:43 下午
 * @Email: yongye.ysf@raycloud.com
 */
@SpringBootApplication
@EnableResourceServer
public class UserOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserOauthApplication.class,args);
    }
}
