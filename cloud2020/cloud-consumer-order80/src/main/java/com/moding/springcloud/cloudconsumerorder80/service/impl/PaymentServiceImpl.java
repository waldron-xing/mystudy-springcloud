package com.moding.springcloud.cloudconsumerorder80.service.impl;

import com.moding.springcloud.cloudconsumerorder80.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentServiceImpl implements PaymentService {



    @Override
    public String paymentInfo(Integer id) {
        return "---订单 id:"+id+" 支付成功！！";
    }


}
