package com.moding.springcloud.cloudconsumerfeignhystrixorder80.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-PaymentFallbackService---paymentInfo_OK id:"+id+" 请稍后再试！";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-PaymentFallbackService---paymentInfo_TimeOut id:"+id+" 请稍后再试！";
    }
}
