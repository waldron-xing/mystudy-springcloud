package com.moding.springcloud.springsecuritydistributeduaa.service.impl;

import com.moding.springcloud.springsecuritydistributeduaa.dao.UserDao;
import com.moding.springcloud.springsecuritydistributeduaa.model.UserDto;
import com.moding.springcloud.springsecuritydistributeduaa.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDto add(UserDto userDto) {
        return userDao.add(userDto);
    }

    @Override
    public int deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public int EditUser() {
        return userDao.EditUser();
    }

    @Override
    public List<UserDto> queryUsers() {
        return userDao.queryUsers();
    }

    @Override
    public UserDto queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }
}
