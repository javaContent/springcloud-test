package com.test.user.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Author:永夜-杨帅菲
 *
 * @Date: 2022/11/8 3:48 下午
 * @Email: yongye.ysf@raycloud.com
 */
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("salary")
                .tokenServices(tokenServices())
                .stateless(true);
//        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/user/**").access("#oauth2.hasScope('all')")
                .antMatchers("/salary/**").hasAnyAuthority("salary")
//                .antMatchers("/test").permitAll()
//                .anyRequest().fullyAuthenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 因为登陆服务的token是存放在内存，所以只能远程调用
     * 可以选择token存放到redis或者jdbc或者jwt
     * @return
     */
//    public ResourceServerTokenServices tokenServices() {
//        RemoteTokenServices services = new RemoteTokenServices();
//        services.setCheckTokenEndpointUrl("http://localhost:8767/oauth/check_token");
//        services.setClientId("c1");
//        services.setClientSecret("secret");
//        return services;
//    }

    public ResourceServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
//        services.setClientDetailsService(clientDetailsService);//客户端详情服务
        services.setTokenStore(tokenStore());//令牌存储，内存
        return services;
    }

    @Bean
    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();//存放在内存--也可以提供redis和jdbc存放token，也可以使用jwt
        return new RedisTokenStore(redisConnectionFactory);//存放在redis
    }
}
