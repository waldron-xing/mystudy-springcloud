package com.moding.springcloud.springsecurityauthserver8080.service;

import com.moding.springcloud.springsecurityauthserver8080.model.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(SpringDataUserDetailsService.class);

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("username="+username);
        UserDto userDto = userService.queryUserByUsername(username);
        if(userDto==null)
            return null;
        UserDetails userDetails = User
                .withUsername(userDto.getUsername())
                .password(userDto.getPassword())
                .authorities("p1")
                .build();

        return userDetails;
    }
}
