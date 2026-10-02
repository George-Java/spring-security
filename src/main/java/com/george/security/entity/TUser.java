package com.george.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class TUser implements UserDetails {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("login_act")
    private String loginAct;

    @TableField("login_pwd")
    @JsonIgnore
    private String loginPwd;

    @TableField("name")
    private String name;

    @TableField("phone")
    @JsonIgnore
    private String phone;

    @TableField("email")
    @JsonIgnore
    private String email;

    @TableField("account_no_expired")
    private int accountNoExpired;

    @TableField("credentials_no_expired")
    private int credentialsNoExpired;

    @TableField("account_no_locked")
    private int accountNoLocked;

    @TableField("account_enabled")
    private int accountEnabled;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss")
    private LocalDateTime createTime;

    @TableField("create_by")
    private int createBy;

    @TableField("edit_time")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss")
    private LocalDateTime editTime;

    @TableField("edit_by")
    private int editBy;

    @TableField("last_login_time")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss")
    private LocalDateTime lastLoginTime;

    @JsonIgnore
    @TableField(exist = false)
    private List<TRole> roleList;

    @JsonIgnore
    @TableField(exist = false)
    private List<TPermission> permissionList;



    // 实现UserDetails中的方法
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 返回用户角色
        //return this.roleList.stream()
        //        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole()))
        //        .collect(Collectors.toList());

        // 返回用户权限控制符
        return this.permissionList.stream()
                .map(p -> new SimpleGrantedAuthority(p.getCode()))
                .collect(Collectors.toList());
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.loginPwd;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return this.loginAct;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNoExpired == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNoLocked == 1;
    }

    @Override
    public boolean isEnabled() {
        return this.accountEnabled == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNoExpired == 1;
    }
}