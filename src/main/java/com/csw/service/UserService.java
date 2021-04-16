package com.csw.service;


import com.csw.entity.User;

/**
 * Created by HIAPAD on 2019/10/30.
 */
public interface UserService {


    User queryUsername(String username);

    void regist(User user);
}
