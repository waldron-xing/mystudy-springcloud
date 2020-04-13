package com.moding.springcloud.springsecuritydistributeduaa.service;


import com.moding.springcloud.springsecuritydistributeduaa.model.UserDto;

import java.util.List;

public interface UserService {

    public UserDto add(UserDto userDto);

    public int deleteUserById(int id);

    public int EditUser();

    public List<UserDto> queryUsers();

    public UserDto queryUserByUsername(String username);
}
