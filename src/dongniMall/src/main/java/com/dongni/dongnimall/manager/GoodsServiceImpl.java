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
    public void addGoods(List<GoodsDO> goodsList) {
        goodsMapper.insertGoods(goodsList);
    }

    @Override
    public void removeGoods(String order_number) {
        goodsMapper.deleteGoods(order_number);
    }

    @Override
    public List<GoodsDO> queryGoods(String order_number) {
        return goodsMapper.selectGoods(order_number);
    }
}
