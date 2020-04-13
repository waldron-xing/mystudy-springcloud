package com.moding.springcloud.springsecuritydistributeduaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableCircuitBreaker //开启hystrix
@EnableFeignClients
public class SpringcloudDistributedUaaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDistributedUaaApplication.class,args);
    }
}
