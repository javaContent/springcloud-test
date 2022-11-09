package com.test.client.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:永夜-杨帅菲
 * 用于服务调用时，security权限验证时，设置用户名密码
 * @Date: 2022/11/2 11:09 下午
 * @Email: yongye.ysf@raycloud.com
 */
@Configuration
public class FeignClientConfig {
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "enjoy");
    }
}
