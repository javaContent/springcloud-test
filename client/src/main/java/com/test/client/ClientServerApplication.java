package com.test.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2021/8/24 7:33 下午
 * @Email: yongye.ysf@raycloud.com
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ClientServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServerApplication.class,args);
    }
}
