package com.george.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/system")
public class SystemController {

    @GetMapping("/management")
    @PreAuthorize("hasAuthority('system:list')")
    public String management() {
        return "系统管理功能未实现";
    }

    @GetMapping("/management/list")
    @PreAuthorize("hasAuthority('system:list')")
    public String list() {
        return "系统列表功能未实现";
    }

    // 用户3没有此权限，用于测试403
    @GetMapping("/management/add")
    @PreAuthorize("hasAuthority('system:add')")
    public String add() {
        return "系统新增功能未实现";
    }
}