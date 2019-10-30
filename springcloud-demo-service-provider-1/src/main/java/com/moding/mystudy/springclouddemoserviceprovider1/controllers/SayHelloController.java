package com.moding.mystudy.springclouddemoserviceprovider1.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 邢卫东
 * @date 2019/10/30
 * @description com.moding.mystudy.springclouddemoserviceprovider1.controllers
 */

@RestController
public class SayHelloController {

    @RequestMapping(value="/hello/{name}")
    public String sayHello(@PathVariable("name") String name){
        return "Hello, ".concat(name).concat("!");
    }
}
