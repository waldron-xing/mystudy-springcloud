package com.moding.springcloud.springsecurityauthserver8080.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login/success")
    @ResponseBody
    public String loginSuccess(){
        return "恭喜，登录成功！";
    }
}
