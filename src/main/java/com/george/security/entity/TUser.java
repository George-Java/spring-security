package com.george.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class TUser {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("login_act")
    private String loginAct;

    @TableField("login_pwd")
    private String loginPwd;

    private String name;

    private String phone;

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
    private LocalDateTime createTime;

    @TableField("create_by")
    private int createBy;

    @TableField("edit_time")
    private LocalDateTime editTime;

    @TableField("edit_by")
    private int editBy;

    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;
}