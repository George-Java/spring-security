package com.george.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clue")
public class ClueController {

    @GetMapping("/management")
    //@PreAuthorize("hasRole('saler')")
    @PreAuthorize("hasAuthority('clue:list')")
    public String management() {
        return "线索管理功能未实现";
    }

    @GetMapping("/management/child")
    //@PreAuthorize("hasRole('saler')")
    @PreAuthorize("hasAuthority('clue:list')")
    public String managementChild() {
        return "线索管理子功能未实现";
    }

    @GetMapping("/management/list")
    //@PreAuthorize("hasRole('saler')")
    @PreAuthorize("hasAuthority('clue:list')")
    public String list() {
        return "线索列表功能未实现";
    }

    @GetMapping("/management/enter")
    //@PreAuthorize("hasRole('saler')")
    @PreAuthorize("hasAuthority('clue:add')")
    public String enter() {
        return "线索录入功能未实现";
    }

    @GetMapping("/management/edit")
    //@PreAuthorize("hasRole('saler')")
    @PreAuthorize("hasAuthority('clue:edit')")
    public String edit() {
        return "线索编辑功能未实现";
    }

    @GetMapping("/management/view")
    //@PreAuthorize("hasRole('saler')")
    @PreAuthorize("hasAuthority('clue:view')")
    public String view() {
        return "线索查看功能未实现";
    }

    @GetMapping("/management/import")
    //@PreAuthorize("hasRole('saler')")
    @PreAuthorize("hasAuthority('clue:import')")
    public String importClue() {
        return "线索导入功能未实现";
    }

    // 用户3没有此权限，用于测试403
    @GetMapping("/management/delete")
    //@PreAuthorize("hasAnyRole('admin','manager')")
    @PreAuthorize("hasAnyAuthority('clue:delete','clue:remove')")
    public String delete() {
        return "线索删除功能未实现";
    }
}