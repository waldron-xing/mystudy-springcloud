package com.moding.springcloud.springsecurityauthserver8080.model;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer enabled;
}
