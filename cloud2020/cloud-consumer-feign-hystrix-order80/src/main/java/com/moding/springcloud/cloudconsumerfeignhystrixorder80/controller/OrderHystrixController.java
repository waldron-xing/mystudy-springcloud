package com.moding.springcloud.cloudconsumerfeignhystrixorder80.controller;

import com.moding.springcloud.cloudconsumerfeignhystrixorder80.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") //使用统计默认的全局服务降级方法
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    }) //指定服务降级方法
    //@HystrixCommand //使用默认的服务降级方法
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
//        int age = 10/0;//手动制造运行时异常。
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_TimeOutHandler,id:  "+id+"\t"+"  /(ㄒoㄒ)/~~";
    }


    public String payment_Global_FallbackMethod(){

        return  "全局服务降级方法，请稍后再试！";
    }

}
