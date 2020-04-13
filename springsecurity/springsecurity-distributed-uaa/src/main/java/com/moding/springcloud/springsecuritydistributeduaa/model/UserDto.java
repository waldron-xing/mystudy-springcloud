package com.moding.springcloud.springsecuritydistributeduaa.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer enabled;
}
