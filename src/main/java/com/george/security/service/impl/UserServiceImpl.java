package com.george.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.george.security.entity.TPermission;
import com.george.security.entity.TRole;
import com.george.security.entity.TUser;
import com.george.security.mapper.TPermissionMapper;
import com.george.security.mapper.TRoleMapper;
import com.george.security.mapper.TUserMapper;
import com.george.security.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements UserService {
    private final TRoleMapper roleMapper;

    private final TPermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        // 查询用户基本信息
        TUser user = lambdaQuery().eq(TUser::getLoginAct, username).one();

        // 权限控制：方式一 查询用户角色
        //List<TRole> roleList = roleMapper.selectRolesByUserId(user.getId());
        //user.setRoleList(roleList);

        // 权限控制：方式二 查询用户拥有的权限控制符
        List<TPermission> permissionList = permissionMapper.selectPermissionsByUserId(user.getId());
        user.setPermissionList(permissionList);

        return user;
    }
}
