package com.ding.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ding.user.Mapper.UserMapper;
import com.ding.user.entity.UmsAdmin;
import com.ding.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public void registerUser(UmsAdmin userAdmin) {

    }

    @Override
    public List<UmsAdmin> selectUser() {
        QueryWrapper<UmsAdmin> userAdminQueryWrapper = new QueryWrapper<>();
        userAdminQueryWrapper.eq("username","admin");
        List<UmsAdmin> userAdmins = userMapper.selectList(userAdminQueryWrapper);
        return userAdmins;
    }
}
