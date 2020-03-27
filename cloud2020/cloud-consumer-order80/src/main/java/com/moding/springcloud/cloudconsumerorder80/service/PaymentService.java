package com.moding.springcloud.cloudconsumerorder80.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public interface PaymentService {
    public String paymentInfo(Integer id);
}
