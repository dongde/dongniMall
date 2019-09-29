package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.BaseTradeMapper;
import com.dongni.dongnimall.pojo.BaseStoreDO;
import com.dongni.dongnimall.vo.BaseStoreVO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseTradeServiceImpl implements BaseTradeService {


    @Autowired
    private BaseTradeMapper baseTradeMapper;


    @Override
    public PageData selectAllTrade(Integer page, Integer limit, String tradeName, String tradeType) {
        if(page==null){
            page = 1;
        }
        if(limit==null){
            limit = 10;
        }
        List<BaseStoreVO> baseStoreVOS = new ArrayList<>();
        PageHelper.startPage(page, limit);
        List<BaseStoreDO> baseStoreDOS = baseTradeMapper.selectAllTrade(tradeName, tradeType);
        PageInfo<BaseStoreDO> pageInfo = new PageInfo<>(baseStoreDOS);
        for (BaseStoreDO baseStoreDO : baseStoreDOS) {
            List<String> lists = new ArrayList<>();
            BaseStoreVO baseStoreVO = new BaseStoreVO();
            baseStoreVO.setId(baseStoreDO.getId());
            baseStoreVO.setTradeURL(baseStoreDO.getTradeURL());
            baseStoreVO.setContent(baseStoreDO.getContent());
            baseStoreVO.setPrice(baseStoreDO.getPrice());
            baseStoreVO.setTradeName(baseStoreDO.getTradeName());
            baseStoreVO.setUpdateTime(baseStoreDO.getUpdateTime());
            baseStoreVO.setTradeType(baseStoreDO.getTradeType());
            baseStoreVO.setViewCount(baseStoreDO.getViewCount());
            String imageURL = baseStoreDO.getImageURL();
            String[] images = imageURL.split(",");
            for (String image : images) {
                lists.add(image);
            }
            baseStoreVO.setImageURLs(lists);
            baseStoreVOS.add(baseStoreVO);

        }
        PageData pageData = new PageData();
        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setMsg("");
        pageData.setData(baseStoreVOS);
        return pageData;

    }

    @Override
    public void insertTrade(BaseStoreDO baseStoreDO) {
        baseTradeMapper.insertTrade(baseStoreDO);
    }

    @Override
    public void deleteByID(String id) {
        baseTradeMapper.deleteTrade(id);
    }

    @Override
    public BaseStoreDO selectByID(String id) {
        return baseTradeMapper.selectByID(id);
    }

    @Override
    public void updateTrade(BaseStoreDO baseStoreDO) {
        baseTradeMapper.updateTrade(baseStoreDO);
    }
}
