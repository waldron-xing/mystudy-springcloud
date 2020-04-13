package com.moding.springcloud.springsecurityauthserver8080;


import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestBCrype {

    public void testBCtype(){
        String hashpw = BCrypt.hashpw("123",BCrypt.gensalt());

    }

}
