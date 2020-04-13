package com.moding.springcloud.springsecuritydistributeduaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


//@Configuration
/**
 * 自定义clientDetailService
 */
public class SpringDataClientDetailsService implements ClientDetailsService {

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        /*
        * public BaseClientDetails(String clientId, String resourceIds,
			String scopes, String grantTypes, String authorities,
			String redirectUris)
        * */
        System.out.println("clientId = " + clientId);
        BaseClientDetails details = new BaseClientDetails("c1",
                "res1",
                "all",
                "password",
                "p1");
        details.setClientSecret("secret");
        details.setAccessTokenValiditySeconds(7200);
        details.setRefreshTokenValiditySeconds(520000);
        return details;
    }
}
