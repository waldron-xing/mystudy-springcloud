package com.moding.springcloud.microservicecloudproviderdept8001.controllers;

import com.moding.springcloud.entities.Dept;
import com.moding.springcloud.microservicecloudproviderdept8001.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @ResponseBody
    @RequestMapping("/list")
    public List<Dept> selectDepts(){
        return deptService.selectDepts();
    }
}
