package com.george.security.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
// 启用@PreAuthorize和PostAuthorize注解
@EnableMethodSecurity
@MapperScan(basePackages = "com.george.security.mapper")
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 配置Spring Security的一些行为
    // 配置Spring Security使用自定义登录页面
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName(null);
        return httpSecurity
                .csrf(csrf ->
                        csrf
                                .csrfTokenRequestHandler(requestHandler))
                // 指定登录页面
                .formLogin(formLoginConfigurer ->
                                formLoginConfigurer
                                        // 定制登录页资源路径
                                        .loginPage("/toLogin")
                                        // 定制登录处理程序资源路径
                                        .loginProcessingUrl("/login")
                        // 定制登录成功后跳转到的资源路径,默认返回登录前的资源路径
                        //.successForwardUrl("/success")
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
