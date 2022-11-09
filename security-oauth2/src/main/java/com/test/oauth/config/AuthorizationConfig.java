package com.test.oauth.config;

import com.test.oauth.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/8 2:04 下午
 * @Email: yongye.ysf@raycloud.com
 */
@Configuration
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 认证管理器
     *
     * @see SecurityConfig 的authenticationManagerBean()
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
//        super.configure(security);
    }

    /**
     * 配置appID、secret
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        super.configure(clients);
        clients.inMemory()//通过内存配置
                .withClient("c1")//clientID
                .secret("secret")//密钥
                .resourceIds("salary","product")//资源ID
                .authorizedGrantTypes("authorization_code","client_credentials","implicit","password","refresh_token")//认证类型
                .scopes("all")//允许的
                .autoApprove(false)//跳转授权页面
                .redirectUris("http://www.baidu.com");
    }

    /**
     * 配置端点
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        super.configure(endpoints);
        endpoints.authenticationManager(authenticationManager)//认证管理器
                .userDetailsService(userService)//密码模式的用户信息管理
                .authorizationCodeServices(authorizationCodeServices)//授权码服务
                .tokenServices(tokenServices())//令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

    @Autowired(required=false)
    private ClientDetailsService clientDetailsService;

    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService);//客户端详情服务
        services.setSupportRefreshToken(true);
        services.setTokenStore(tokenStore());//令牌存储，内存
        services.setAccessTokenValiditySeconds(7200);//token有效期
        services.setRefreshTokenValiditySeconds(259200); //刷新token有效期
        return services;
    }



    @Bean
    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();//存放在内存--也可以提供redis和jdbc存放token，也可以使用jwt
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * 设置授权码模式存取方式
     * @return
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }



}
