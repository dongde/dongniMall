package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.BaseStoreDO;
import com.dongni.dongnimall.vo.PageData;

public interface BaseTradeService {
    /**
     * 查找所有
     * @param page
     * @param limit
     * @param tradeName
     * @param tradeType
     * @return
     */
    PageData selectAllTrade(Integer page, Integer limit, String tradeName, String tradeType);

    /**
     * 添加底料信息
     * @param baseStoreDO
     */
    void insertTrade(BaseStoreDO baseStoreDO);

    /**
     * 通过id删除数据
     * @param id
     */
    void deleteByID(String id);

    /**
     * 通过id查询信息
     * @param id
     * @return
     */
    BaseStoreDO selectByID(String id);

    /**
     * 更新修改
     * @param baseStoreDO
     */
    void updateTrade(BaseStoreDO baseStoreDO);
}
