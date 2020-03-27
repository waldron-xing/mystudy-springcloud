package com.moding.springcloud.cloudconsumerorder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
public class CloudConsumerOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80Application.class,args);
    }
}
