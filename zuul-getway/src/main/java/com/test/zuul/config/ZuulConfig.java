package com.test.zuul.config;

import com.test.zuul.filter.AuthorizedRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/3 7:16 下午
 * @Email: yongye.ysf@raycloud.com
 */
@Configuration
public class ZuulConfig {

    @Bean
    public AuthorizedRequestFilter getAuthorizedRequestFilter() {
        return new AuthorizedRequestFilter();
    }
}
