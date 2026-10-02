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
@TableName("t_permission")
public class TPermission {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("name")
    private String name;

    @TableField("code")
    private String code;

    @TableField("url")
    private String url;

    @TableField("type")
    private String type;

    @TableField("parent_id")
    private int parentId;

    @TableField("order_no")
    private int orderNo;

    @TableField("icon")
    private String icon;

    @TableField("component")
    private String component;
}
