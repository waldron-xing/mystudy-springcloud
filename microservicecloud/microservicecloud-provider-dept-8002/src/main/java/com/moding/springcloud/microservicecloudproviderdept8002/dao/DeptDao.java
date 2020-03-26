package com.moding.springcloud.microservicecloudproviderdept8002.dao;

import com.moding.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptDao {

    int insert(Dept dept);

    void deleteDeptById(@Param("deptno") long deptno);

    void updateUser(Dept dept);

    List<Dept> selectDepts();
}
