package com.moding.springcloud.springsecurityauthserver8080.dao;

import com.moding.springcloud.springsecurityauthserver8080.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    public UserDto add(UserDto userDto);

    public int deleteUserById(int id);

    public int EditUser();

    public List<UserDto> queryUsers();

    public UserDto queryUserByUsername(String username);

}
