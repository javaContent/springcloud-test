package com.test.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/8 11:40 上午
 * @Email: yongye.ysf@raycloud.com
 */
@SpringBootApplication
@EnableAuthorizationServer
public class OauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class,args);
    }
}
