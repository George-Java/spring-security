package com.george.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.george.security.entity.TUser;
import com.george.security.mapper.TUserMapper;
import com.george.security.service.UserService;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements UserService {
    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return lambdaQuery().eq(TUser::getLoginAct, username).one();
    }
}
