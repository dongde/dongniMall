package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Repository
public interface UserMapper {
    void insertUser(UserDO userDO);

    void deleteUser(List<String> phones);

    List<UserDO> selectUserList(@Param("phone") String phone,@Param("name") String name);

    UserDO selectUserByPhone(String phone);

    void updateUser(@Param("userDO") UserDO userDO);

    UserDO selectUserByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);
}
