package com.moding.springcloud.cloudproviderhystrixpayment8001.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {

    /**
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_OK,id:  "+id+"\t"+"  O(∩_∩)O哈哈~";
    }
    /**
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int age = 10/0;//制造运行时异常，激活handler方法
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_TimeOut,id:  "+id+"\t"+"  O(∩_∩)O哈哈~"+"  耗时3秒钟！";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_TimeOutHandler,id:  "+id+"\t"+"  /(ㄒoㄒ)/~~";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸 60代表  60%
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){

        if(id<0){
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_Fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~ id:"+id;
    }
}
