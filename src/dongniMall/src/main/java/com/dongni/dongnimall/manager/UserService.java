package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.UserDO;
import com.dongni.dongnimall.vo.PageData;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
public interface UserService {
    /**
     * @param userDO
     * @Description: 添加用户
     */
    void addUser(UserDO userDO);

    /**
     * @param phones
     * @Description: 删除用户
     */
    void removeUser(List<String> phones);

    /**
     * @param page
     * @param pageSize
     * @return
     * @Description: 查询用户列表
     */
    PageData queryUserList(Integer page, Integer pageSize);

    /**
     * @param userDO
     * @Description: 修改用户信息
     */
    void modifyUser(UserDO userDO);

    /**
     * @Description: 验证用户密码是否正确
     * @param phone
     * @param password
     * @return
     */
    UserDO queryUserByPhoneAndPassword(String phone,String password);
}
