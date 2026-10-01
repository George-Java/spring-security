package com.george.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Slf4j
@Controller("/")
public class HelloController {
    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Welcome Spring Security!";
    }

    @GetMapping("/toLogin")
    public String login() {
        return "login";
    }

    // 获取用户登录信息
    // 方式一
    @RequestMapping("/success")
    @ResponseBody
    public Object success(@Autowired Principal principal) {
        return principal;
    }

    // 方式二
    @RequestMapping("/success2")
    @ResponseBody
    public Object success2(@Autowired Authentication authentication) {
        return authentication;
    }

    // 方式三
    @RequestMapping("/success3")
    @ResponseBody
    public Object success3(@Autowired UsernamePasswordAuthenticationToken token) {
        return token;
    }

    // 方式四
    @RequestMapping("/success4")
    @ResponseBody
    public Object success4() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
