package com.csw.dao;

import com.csw.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by HIAPAD on 2019/10/30.
 */
public interface UserDao {
    User queryUsername(@Param("username") String username);

    void regist(@Param("u") User user);
}
