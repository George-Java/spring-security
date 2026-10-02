package com.george.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @GetMapping("/management")
    @PreAuthorize("hasAuthority('customer:list')")
    public String management() {
        return "客户管理功能未实现";
    }

    @GetMapping("/management/list")
    @PreAuthorize("hasAuthority('customer:list')")
    public String list() {
        return "客户列表功能未实现";
    }

    @GetMapping("/management/view")
    @PreAuthorize("hasAuthority('customer:view')")
    public String view() {
        return "客户查看功能未实现";
    }

    @GetMapping("/management/export")
    @PreAuthorize("hasAuthority('customer:export')")
    public String export() {
        return "客户导出功能未实现";
    }

    // 用户3没有此权限，用于测试403
    @GetMapping("/management/add")
    @PreAuthorize("hasAuthority('customer:add')")
    public String add() {
        return "客户新增功能未实现";
    }
}