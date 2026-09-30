package com.george.security.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@MapperScan(basePackages = "com.george.security.mapper")
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    // 配置Spring Security的一些行为
    // 配置Spring Security使用自定义登录页面
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // 指定登录页面
                .formLogin(
                        formLoginConfigurer ->
                                formLoginConfigurer
                                        .loginProcessingUrl("/login")
                                        .loginPage("/toLogin")
                )

                // 配置自定义登录页面后，Spring Security的某些默认行为会丢失，需要重新配置Spring Security拦截所有请求
                .authorizeHttpRequests(authorizationManager ->
                        authorizationManager
                                // 放行登录页访问请求：登录页不需要认证即可访问
                                .requestMatchers("/toLogin").permitAll()
                                // 拦截其他所有请求
                                .anyRequest().authenticated())

                .build();
    }
}
