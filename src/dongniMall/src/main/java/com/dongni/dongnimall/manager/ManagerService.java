package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.ManagerDO;
import com.dongni.dongnimall.vo.PageData;

/**
 * @author cengshuai on 2019-09-09.
 * @version 1.0
 */
public interface ManagerService {
    /**
     * @param page
     * @param pageSize
     * @return
     * @Description: 获取所有管理员用户
     */
    PageData queryManagerList(Integer page, Integer pageSize);

    /**
     * @param managerDO
     * @Description: 添加管理员
     */
    void addManager(ManagerDO managerDO);

    /**
     * @Description: 查询用户是否已经存在
     * @param name
     * @return
     */
    boolean queryManagerByName(String name, String id);

    /**
     * @Description: 查询用户密码是否正确
     * @param name
     * @param password
     * @return
     */
    ManagerDO queryManagerByNameAndPassword(String name, String password);

    /**
     * @Description: 修改管理员信息
     * @param managerDO
     */
    void modifyManager(ManagerDO managerDO);

    /**
     * @Description: 删除管理员
     * @param id
     */
    void removeManager(String id);
}
