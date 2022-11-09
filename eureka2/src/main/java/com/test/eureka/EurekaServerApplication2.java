package com.test.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2021/8/24 2:57 下午
 * @Email: yongye.ysf@raycloud.com
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication2.class, args);
    }
}
