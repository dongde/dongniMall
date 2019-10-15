package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.GoodsDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Repository
public interface GoodsMapper {
    /**
     * @Description: 添加交易商品信息
     * @param goodsDO
     */
    void insertGoods(@Param("goodsDO") GoodsDO goodsDO);

    /**
     * @Description: 修改购物车商品信息
     * @param goodsDO
     */
    void updateGoods(@Param("goodsDO") GoodsDO goodsDO);

    /**
     * @Description: 删除订单相关商品
     * @param order_number
     */
    void deleteGoodsByOrderNumber(String order_number);

    /**
     * @Description: 根据ID删除购物车商品信息
     * @param id
     */
    void deleteGoodsById(String id);

    /**
     * @Description: 查询购物车商品
     * @param user_phone
     * @return
     */
    List<GoodsDO> selectGoods(String user_phone);

    /**
     * @Description: 查询订单商品列表
     * @param order_number
     * @return
     */
    List<GoodsDO> selectOrderGoods(String order_number);

    /**
     * @Description: 商品信息添加订单号
     * @param order_number
     * @param goodsIdList
     */
    void updateGoodsOrderNumber(String order_number,List<String> goodsIdList);
}
