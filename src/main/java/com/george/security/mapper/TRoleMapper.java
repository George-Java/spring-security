package com.george.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.george.security.entity.TRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRoleMapper extends BaseMapper<TRole> {
    List<TRole> selectRolesByUserId(@Param("userId") int userId);
}
