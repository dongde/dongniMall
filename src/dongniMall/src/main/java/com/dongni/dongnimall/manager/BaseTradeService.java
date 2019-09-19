package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.BaseStore;
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
     * @param baseStore
     */
    void insertTrade(BaseStore baseStore);

    /**
     * 通过id删除数据
     * @param id
     */
    void deleteByID(Integer id);

    /**
     * 通过id查询信息
     * @param id
     * @return
     */
    BaseStore selectByID(Integer id);

    /**
     * 更新修改
     * @param baseStore
     */
    void updateTrade(BaseStore baseStore);
}
