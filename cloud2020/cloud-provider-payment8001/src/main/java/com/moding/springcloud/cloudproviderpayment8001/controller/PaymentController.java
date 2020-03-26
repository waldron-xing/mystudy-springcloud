package com.moding.springcloud.cloudproviderpayment8001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public String get(@PathVariable("id") Integer id){
        return "get payment id: "+id;
    }

    @GetMapping("/payment/lb")
    public String lb(){
        return "lb payment serverPort: "+serverPort;
    }
}
