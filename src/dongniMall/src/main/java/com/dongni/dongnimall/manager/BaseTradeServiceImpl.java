package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.BaseImageMapper;
import com.dongni.dongnimall.dao.BaseTradeMapper;
import com.dongni.dongnimall.pojo.BaseImageDO;
import com.dongni.dongnimall.pojo.BaseStoreDO;
import com.dongni.dongnimall.vo.BaseStoreVO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseTradeServiceImpl implements BaseTradeService {


    @Autowired
    private BaseImageMapper baseImageMapper;

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
        PageHelper.startPage(page, limit);
        List<BaseStoreDO> baseStoreDOS = baseTradeMapper.selectAllTrade(tradeName, tradeType);
        PageInfo<BaseStoreDO> pageInfo = new PageInfo<>(baseStoreDOS);
        PageData pageData = new PageData();
        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setMsg("");
        pageData.setData(baseStoreDOS);
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

    @Override
    public BaseStoreVO selectDetails(String id) {
        BaseStoreVO baseStoreVO = new BaseStoreVO();
        BaseStoreDO baseStoreDO = baseTradeMapper.selectByID(id);
        List<BaseImageDO> baseImageDOS = baseImageMapper.findByID(id);
        List<String> lists = new ArrayList<>();
        BeanUtils.copyProperties(baseStoreDO,baseStoreVO);
        for (BaseImageDO baseImageDO : baseImageDOS) {
            lists.add(baseImageDO.getImageURL());
        }
        baseStoreVO.setImages(lists);

        return baseStoreVO;
    }
}
