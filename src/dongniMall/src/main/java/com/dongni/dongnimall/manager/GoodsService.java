package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.GoodsDO;
import com.dongni.dongnimall.vo.PageData;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
public interface GoodsService {
    /**
     * @param goodsList
     * @Description: 添加商品信息
     */
    void addGoods(List<GoodsDO> goodsList);

    /**
     * @param order_number
     * @Description: 删除购买的商品信息
     */
    void removeGoods(String order_number);

    /**
     * @param order_number
     * @return
     * @Description: 查询购买的商品信息
     */
    List<GoodsDO> queryGoods(String order_number);
}
