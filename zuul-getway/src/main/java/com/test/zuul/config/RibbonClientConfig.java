package com.test.zuul.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:永夜-杨帅菲
 * 负载均衡策略
 * @Date: 2022/11/3 7:50 下午
 * @Email: yongye.ysf@raycloud.com
 */
@Configuration
public class RibbonClientConfig {

    @Bean
    public IRule getRule() {
        return new RandomRule();
    }
}
