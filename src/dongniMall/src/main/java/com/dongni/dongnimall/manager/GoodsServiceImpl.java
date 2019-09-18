package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.GoodsMapper;
import com.dongni.dongnimall.pojo.GoodsDO;
import com.dongni.dongnimall.pojo.LogisticsDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public void addGoods(GoodsDO goodsDO) {
        goodsMapper.insertGoods(goodsDO);
    }

    @Override
    public void removeGoods(String order_number) {
        goodsMapper.deleteGoods(order_number);
    }

    @Override
    public PageData queryGoods(Integer page, Integer pageSize, String order_number) {
        PageHelper.startPage(page, pageSize);
        List<GoodsDO> list = goodsMapper.selectGoods(order_number);
        PageInfo<GoodsDO> pageInfo = new PageInfo<>(list);
        PageData pageData = new PageData();
        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setData(list);
        pageData.setMsg("");
        return pageData;
    }
}
