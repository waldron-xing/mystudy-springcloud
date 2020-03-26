package com.moding.springcloud.microservicecloudconsumerdept80.controllers;

import com.moding.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    private final String REST_URL_PRIFIX = "http://microservicecloud-dept/";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PRIFIX+"dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PRIFIX+"dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> selectDepts(){
        return restTemplate.getForObject(REST_URL_PRIFIX+"dept/list",List.class);
    }



}
