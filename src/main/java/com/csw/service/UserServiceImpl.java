package com.csw.service;

import com.csw.dao.UserDao;
import com.csw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HIAPAD on 2019/10/30.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryUsername(String username) {
        return userDao.queryUsername(username);
    }

    @Override
    public void regist(User user) {
        userDao.regist(user);
    }

    /* @Transactional(propagation = Propagation.SUPPORTS)*/
}
