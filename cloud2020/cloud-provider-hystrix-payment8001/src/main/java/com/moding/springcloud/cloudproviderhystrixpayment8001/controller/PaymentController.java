package com.moding.springcloud.cloudproviderhystrixpayment8001.controller;

import com.moding.springcloud.cloudproviderhystrixpayment8001.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        return result;
    }

    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentInfo_CircuitBreaker(@PathVariable("id")Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        return result;
    }
}
