package com.moding.springcloud.cloudconsumerorder80.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
