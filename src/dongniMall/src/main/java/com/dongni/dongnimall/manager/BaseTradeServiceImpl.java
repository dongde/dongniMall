package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.BaseTradeMapper;
import com.dongni.dongnimall.pojo.BaseStore;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseTradeServiceImpl implements BaseTradeService {


    @Autowired
    private BaseTradeMapper baseTradeMapper;


    @Override
    public PageData selectAllTrade(Integer page, Integer limit, String tradeName, String tradeType) {
        PageHelper.startPage(page, limit);
        List<BaseStore> baseStores = baseTradeMapper.selectAllTrade(tradeName,tradeType);
        PageInfo<BaseStore> pageInfo = new PageInfo<>(baseStores);
        PageData pageData = new PageData();
        if(baseStores!=null) {
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(baseStores);
            return pageData;
        }else {
            pageData.setCode(1);
            pageData.setCount(0);
            pageData.setMsg("获取数据失败");
            pageData.setData(null);
            return pageData;
        }
    }

    @Override
    public void insertTrade(BaseStore baseStore) {
        baseTradeMapper.insertTrade(baseStore);
    }

    @Override
    public void deleteByID(Integer id) {
        baseTradeMapper.deleteTrade(id);
    }

    @Override
    public BaseStore selectByID(Integer id) {
        return baseTradeMapper.selectByID(id);
    }

    @Override
    public void updateTrade(BaseStore baseStore) {
        baseTradeMapper.updateTrade(baseStore);
    }
}
