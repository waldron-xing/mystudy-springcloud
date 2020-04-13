package com.moding.springcloud.microservicecloudproviderdept8003.service.impl;

import com.moding.springcloud.entities.Dept;
import com.moding.springcloud.microservicecloudproviderdept8003.dao.DeptDao;
import com.moding.springcloud.microservicecloudproviderdept8003.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {


    @Resource
    private DeptDao deptDao;//这里会爆红，请忽略

    @Override
    public int insert(Dept dept) {
        return 0;
    }

    @Override
    public void deleteDeptById(Long deptno) {

    }

    @Override
    public void updateDept(Dept dept) {

    }

    @Override
    public List<Dept> selectDepts() {
        return deptDao.selectDepts();
    }
}
