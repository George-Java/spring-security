package com.george.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.george.security.entity.TPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPermissionMapper extends BaseMapper<TPermission> {
    List<TPermission> selectPermissionsByUserId(@Param("userId") int userId);
}
