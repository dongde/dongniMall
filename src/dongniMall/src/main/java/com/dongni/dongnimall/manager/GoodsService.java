package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.GoodsDO;
import com.dongni.dongnimall.vo.PageData;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
public interface GoodsService {
    /**
     * @Description: 添加商品信息
     * @param goodsDO
     */
    void addGoods(GoodsDO goodsDO);

    /**
     * @Description: 删除购买的商品信息
     * @param order_number
     */
    void removeGoods(String order_number);

    /**
     * @Description: 查询购买的商品信息
     * @return
     */
    PageData queryGoods(Integer page,Integer pageSize,String order_number);
}
