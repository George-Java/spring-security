package com.george.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 
 * @since 2026-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自动增长，用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录账号
     */
    @TableField("login_act")
    private String loginAct;

    /**
     * 登录密码
     */
    @TableField("login_pwd")
    private String loginPwd;

    /**
     * 用户姓名
     */
    @TableField("name")
    private String name;

    /**
     * 用户手机
     */
    @TableField("phone")
    private String phone;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 账户是否没有过期，0已过期 1正常
     */
    @TableField("account_no_expired")
    private Integer accountNoExpired;

    /**
     * 密码是否没有过期，0已过期 1正常
     */
    @TableField("credentials_no_expired")
    private Integer credentialsNoExpired;

    /**
     * 账号是否没有锁定，0已锁定 1正常
     */
    @TableField("account_no_locked")
    private Integer accountNoLocked;

    /**
     * 账号是否启用，0禁用 1启用
     */
    @TableField("account_enabled")
    private Integer accountEnabled;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField("create_by")
    private Integer createBy;

    /**
     * 编辑时间
     */
    @TableField("edit_time")
    private LocalDateTime editTime;

    /**
     * 编辑人
     */
    @TableField("edit_by")
    private Integer editBy;

    /**
     * 最近登录时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;


}
