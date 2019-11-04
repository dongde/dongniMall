package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.RecInfoDO;

import java.util.List;

/**
 * @author cengshuai on 2019-11-02.
 * @version 1.0
 */
public interface RecInfoService {

    /**
     * 添加收货人信息
     * @param recInfoDO
     */
    void addRecInfo(RecInfoDO recInfoDO);

    /**
     * 查询用户收货人信息列表
     * @param user_phone
     * @return
     */
    List<RecInfoDO> queryRecInfoListByUserPhone(String user_phone);

    /**
     * 查询收货人信息
     * @param id
     * @return
     */
    RecInfoDO queryRecInfoById(String id);

    /**
     * 删除收货人信息
     * @param id
     */
    void removeRecInfoById(String id);

    /**
     * 修改收货人信息
     * @param recInfoDO
     */
    void modifyRecInfoById(RecInfoDO recInfoDO);

    /**
     * 设置默认收货地址
     * @param id
     */
    void modifyRecInfoDefaultStatus(String id);
}
