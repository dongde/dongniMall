package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.BaseTradeTypeDO;
import com.dongni.dongnimall.vo.PageData;

public interface BaseTradeTypeService {

    /**
     * 查询所有类型
     * @param page
     * @param limit
     * @return
     */
    PageData selectAllType(Integer page, Integer limit);

    /**
     * 插入类型
     */
    void insertType(BaseTradeTypeDO baseTradeTypeDO);

    /**
     * 删除类型数据
     */
    void deleteType(String id);
}
