package com.moding.mystudy.springclouddemoeurekaserver3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudDemoEurekaserver3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDemoEurekaserver3Application.class, args);
    }

}
