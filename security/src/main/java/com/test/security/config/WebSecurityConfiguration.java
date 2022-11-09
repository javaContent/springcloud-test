package com.test.security.config;

import com.test.security.server.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @Author:永夜-杨帅菲
 * @Date: 2022/11/2 9:40 下午
 * @Email: yongye.ysf@raycloud.com
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserService userService;
    /**
     * 新增Security授权账号
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password(new BCryptPasswordEncoder().encode("enjoy")).roles("USER").
//                and().withUser("admin").password(new BCryptPasswordEncoder().encode("enjoy")).roles("USER", "ADMIN");

        /**
         * 需要用户名user+密码password登陆认证
         * password需要使用加密
         */
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("root").password(new BCryptPasswordEncoder().encode("root")).authorities("/");
        /**
         * 使用非加密方式，需要配置下面的bean：NoOpPasswordEncoder
         */
//        auth.inMemoryAuthentication().withUser("admin").password("enjoy").authorities("/");
//        auth.inMemoryAuthentication().withUser("root").password("root").authorities("addMember","delMember","getMember");
//        auth.inMemoryAuthentication().withUser("user_add").password("user_add").authorities("addMember");
//        auth.inMemoryAuthentication().withUser("user_del").password("user_del").authorities("delMember");
//        auth.inMemoryAuthentication().withUser("user_get").password("user_get").authorities("getMember");
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 拦截所有请求，使用basic模式登陆
         */
//        http.httpBasic().and().authorizeRequests().anyRequest()
//                .fullyAuthenticated();
        /**
         * 拦截所有请求，使用from表单模式登陆
         */
//        http.formLogin().and().authorizeRequests().anyRequest()
//                .fullyAuthenticated();
        /**
         * 权限分配
         */
        http.formLogin().and().authorizeRequests()
                .antMatchers("/addMember").hasAnyAuthority("addMember")
                .antMatchers("/delMember").hasAnyAuthority("delMember")
                .antMatchers("/getMember").hasAnyAuthority("getMember")
            .antMatchers("/**").fullyAuthenticated();//拦截其他所有请求

        /**
         * 登陆页面定制
         */
//        http.authorizeRequests()
//                .antMatchers("/addMember").hasAnyAuthority("addMember")
//                .antMatchers("/delMember").hasAnyAuthority("delMember")
//                .antMatchers("/getMember").hasAnyAuthority("getMember")
////                .antMatchers("/login").permitAll() //放开不拦截
//                .antMatchers("/**").fullyAuthenticated()//拦截其他所有请求
//                .and().formLogin().loginPage("/login").and().csrf().disable();//自定义登陆页面。csrf().disable()关跨域保护

//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    /**
     * 用户密码不使用加密模式
     * @return
     */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
