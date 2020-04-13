package com.moding.springcloud.springsecuritydistributeduaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    public TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    public JwtAccessTokenConverter accessTokenConverter;

    /**
     * 定义一个clientDetailsService
     * @return
     */
    @Bean
    public ClientDetailsService clientDetailsService(DataSource dataSource){
        ClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        ((JdbcClientDetailsService)clientDetailsService).setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return clientDetailsService;
    }

    /**
     * 用户配置那些客户端可以访问授权服务器，获取token
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置一个客户端
        //既可以通过授权码类型获取令牌，也可以通过密码类型获取令牌
        /*clients
                .inMemory()
                .withClient("c1") //客户端ID
                .authorizedGrantTypes("authorization_code","password","refresh_token") //客户端可以使用的授权类型
                .resourceIds("res1")
                .scopes("all") //允许请求范围
                .secret("secret") //客户端安全码
                .autoApprove()
                .redirectUris("http://localhost:8888"); //回调地址*/
        clients.withClientDetails(clientDetailsService);
//        clients.jdbc(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    /**
     * 令牌访问服务
     * @return
     */
    @Bean
    public AuthorizationServerTokenServices tokenServices(){
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService);
        services.setSupportRefreshToken(true);//是否产生令牌刷新
        services.setTokenStore(tokenStore);

        //令牌增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
        services.setTokenEnhancer(tokenEnhancerChain);

        services.setAccessTokenValiditySeconds(7200);//令牌默认有效期2小时
        services.setRefreshTokenValiditySeconds(259200);//刷新令牌默认有效期3天
        return services;
    }

    /**
     * 授权码服务
     * @return
     */
    @Bean
    /*public AuthorizationCodeServices authorizationCodeServices(){
        return new InMemoryAuthorizationCodeServices();
    }*/

    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource){
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    /**
     * 令牌访问端点
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager) //密码模式需要
                .authorizationCodeServices(authorizationCodeServices) //授权码模式需要
                .tokenServices(tokenServices()) //令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);//端点允许post提交
    }

    /**
     * 令牌访问端点安全策略
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()") // /oauth/token_key 公开
                .checkTokenAccess("permitAll()") // /oauth/check_token 公开
                .allowFormAuthenticationForClients(); //
    }
}
