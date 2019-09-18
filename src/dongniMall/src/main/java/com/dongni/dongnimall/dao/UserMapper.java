package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.UserDO;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
public interface UserMapper {
    void insertUser(UserDO userDO);

    void deleteUser(String phone);

    List<UserDO> selectUserList();

    void updateUser(UserDO userDO);
}
