package com.moding.springcloud.microservicecloudproviderdept8002.service;

import com.moding.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

    int insert(Dept dept);

    void deleteDeptById(Long deptno);

    void updateDept(Dept dept);

    List<Dept> selectDepts();
}
