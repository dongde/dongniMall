package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.UserMapper;
import com.dongni.dongnimall.pojo.TeachVideoDO;
import com.dongni.dongnimall.pojo.UserDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cengshuai on 2019-09-18.
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(UserDO userDO) {
        userMapper.insertUser(userDO);
    }

    @Override
    public void removeUser(List<String> phones) {
        userMapper.deleteUser(phones);
    }

    @Override
    public PageData queryUserList(Integer page, Integer pageSize, String phone, String name) {
        PageHelper.startPage(page, pageSize);
        List<UserDO> list = userMapper.selectUserList(phone, name);

        PageInfo<UserDO> pageInfo = new PageInfo<>(list);
        PageData pageData = new PageData();
        pageData.setMsg("");
        pageData.setData(list);
        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        return pageData;
    }


    @Override
    public void modifyUser(UserDO userDO) {
        userMapper.updateUser(userDO);
    }

    @Override
    public UserDO queryUserByPhoneAndPassword(String phone, String password) {
        return userMapper.selectUserByPhoneAndPassword(phone, password);
    }

    @Override
    public UserDO queryUserByPhone(String phone) {
        return userMapper.selectUserByPhone(phone);
    }
}
