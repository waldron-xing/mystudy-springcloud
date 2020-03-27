package com.moding.springcloud.cloudconsumerorder80.controller;

import com.moding.springcloud.cloudconsumerorder80.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo(id);
        return result;
    }

    @GetMapping("/comsumer/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject("http://localhost:8001/payment/zipkin",String.class);
        return result;
    }

}
