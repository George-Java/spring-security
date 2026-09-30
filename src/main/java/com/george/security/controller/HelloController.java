package com.george.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
