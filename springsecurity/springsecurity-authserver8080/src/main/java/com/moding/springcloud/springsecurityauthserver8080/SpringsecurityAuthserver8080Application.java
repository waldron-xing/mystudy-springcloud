package com.moding.springcloud.springsecurityauthserver8080;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class SpringsecurityAuthserver8080Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityAuthserver8080Application.class,args);
    }
}
