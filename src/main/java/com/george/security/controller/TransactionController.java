package com.george.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tran")
public class TransactionController {

    @GetMapping("/management")
    @PreAuthorize("hasAuthority('tran:list')")
    public String management() {
        return "交易管理功能未实现";
    }

    @GetMapping("/management/list")
    @PreAuthorize("hasAuthority('tran:list')")
    public String list() {
        return "交易列表功能未实现";
    }

    @GetMapping("/management/view")
    @PreAuthorize("hasAuthority('tran:view')")
    public String view() {
        return "交易查看功能未实现";
    }

    // 用户3没有此权限，用于测试403
    @GetMapping("/management/edit")
    @PreAuthorize("hasAuthority('tran:edit')")
    public String edit() {
        return "交易编辑功能未实现";
    }
}