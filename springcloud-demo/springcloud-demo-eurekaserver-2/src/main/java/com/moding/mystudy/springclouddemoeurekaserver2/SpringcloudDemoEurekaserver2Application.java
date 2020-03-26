package com.moding.mystudy.springclouddemoeurekaserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudDemoEurekaserver2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDemoEurekaserver2Application.class, args);
    }

}
