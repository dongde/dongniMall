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

    void deleteGoodsByOrderNumber(String order_number);

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
