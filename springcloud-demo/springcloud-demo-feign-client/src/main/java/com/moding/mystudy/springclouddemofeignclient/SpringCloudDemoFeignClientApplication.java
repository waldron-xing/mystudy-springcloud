package com.moding.mystudy.springclouddemofeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudDemoFeignClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoFeignClientApplication.class, args);
    }
}
