package com.moding.mystudy.springclouddemoserviceconsumer1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 邢卫东
 * @date 2019/10/30
 * @description com.moding.mystudy.springclouddemoserviceconsumer1.controllers
 */
@RestController
@Configuration
public class AskController {
    //注册本地服务名
    @Value("${spring.application.name}")
    private String name;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ask")
    public String ask(){
        //从eureka-service-provider-1服务提供者中请求sayHello服务
        String askHelloFromService = restTemplate.getForEntity("http://EUREKA-SERVICE-PROVIDER-1/hello/{name}",
                String.class,name).getBody();
        return askHelloFromService;
    }

    //注册一个可以进行负载均衡的RestTemplate用于服务间的调用
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
