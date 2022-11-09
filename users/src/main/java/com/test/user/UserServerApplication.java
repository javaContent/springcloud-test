package com.test.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2021/8/24 5:05 下午
 * @Email: yongye.ysf@raycloud.com
 */
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker //Hystrix熔断注解
public class UserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class,args);
    }
}
