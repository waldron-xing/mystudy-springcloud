package com.moding.springcloud.springsecurityauthserver8080.service;

import com.moding.springcloud.springsecurityauthserver8080.model.UserDto;

import java.util.List;

public interface UserService {

    public UserDto add(UserDto userDto);

    public int deleteUserById(int id);

    public int EditUser();

    public List<UserDto> queryUsers();

    public UserDto queryUserByUsername(String username);
}
