package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.GoodsMapper;
import com.dongni.dongnimall.pojo.GoodsDO;
import com.dongni.dongnimall.pojo.LogisticsDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public void addGoods(GoodsDO goodsDO) {
        goodsMapper.insertGoods(goodsDO);
    }

    @Override
    public void removeGoodsByOrderNumber(String order_number) {
        goodsMapper.deleteGoodsByOrderNumber(order_number);
    }

    @Override
    public List<GoodsDO> queryGoods(String user_phone) {
        return goodsMapper.selectGoods(user_phone);
    }

    @Override
    public List<GoodsDO> queryOrderGoods(String order_number) {
        return goodsMapper.selectOrderGoods(order_number);
    }

    @Override
    public void removeGoodsById(String id) {
        goodsMapper.deleteGoodsById(id);
    }

    @Override
    public void addOrder(String order_number, List<String> goodsIdList) {
        goodsMapper.updateGoodsOrderNumber(order_number,goodsIdList);
    }
}
