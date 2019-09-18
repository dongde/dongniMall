package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.GoodsDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Repository
public interface GoodsMapper {
    void insertGoods(GoodsDO goodsDO);

    void deleteGoods(String order_number);

    List<GoodsDO> selectGoods(String order_number);
}
