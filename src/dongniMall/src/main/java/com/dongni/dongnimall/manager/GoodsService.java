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
     * @param goodsDO
     * @Description: 添加购物车商品信息
     */
    void addGoods(GoodsDO goodsDO);

    /**
     * @Description: 修改购物车商品信息
     * @param goodsDO
     */
    void modifyGoods(GoodsDO goodsDO);

    /**
     * @param order_number
     * @Description: 根据订单删除购买的商品信息
     */
    void removeGoodsByOrderNumber(String order_number);

    /**
     * @param id
     * @Description: 根据ID删除商品信息
     */
    void removeGoodsById(String id);

    /**
     * @param user_phone
     * @return
     * @Description: 查询用户购物车商品信息
     */
    List<GoodsDO> queryGoods(String user_phone);

    /**
     * @param order_number
     * @return
     * @Description: 查询订单商品信息
     */
    List<GoodsDO> queryOrderGoods(String order_number);

    /**
     * @Description: 给商品添加订单号
     * @param order_number
     * @param goodsIds
     */
    void modifyGoodsOrderNumber(String order_number,List<String> goodsIds);
}
