package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.BaseStore;
import com.dongni.dongnimall.vo.PageData;

public interface BaseTrade {
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
}
