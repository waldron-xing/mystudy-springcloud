package com.moding.springcloud.springsecuritydistributedorder.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping(value = "/r1")
    @PreAuthorize("hasAuthority('p1')")
    public String r1(){
        return "访问资源1";
    }
}
