package com.george.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_role")
public class TRole {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("role")
    private String role;

    @TableField("role_name")
    private String roleName;
}
