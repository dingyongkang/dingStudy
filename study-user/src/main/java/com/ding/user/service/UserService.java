package com.ding.user.service;

import com.ding.user.entity.UmsAdmin;

import java.util.List;

public interface UserService{
    void registerUser(UmsAdmin userAdmin);

    List<UmsAdmin> selectUser();

}
