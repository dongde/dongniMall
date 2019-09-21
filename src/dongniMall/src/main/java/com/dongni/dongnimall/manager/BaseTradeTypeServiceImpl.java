package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.BaseTradeTypeMapper;
import com.dongni.dongnimall.pojo.BaseTradeTypeDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseTradeTypeServiceImpl implements BaseTradeTypeService {

    @Autowired
    private BaseTradeTypeMapper baseTradeTypeMapper;

    @Override
    public PageData selectAllType(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<BaseTradeTypeDO> BaseTradeTypeDOs = baseTradeTypeMapper.selectAllType();
        PageInfo<BaseTradeTypeDO> pageInfo = new PageInfo<>(BaseTradeTypeDOs);
        PageData pageData = new PageData();

        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setMsg("");
        pageData.setData(BaseTradeTypeDOs);
        return pageData;

    }

    @Override
    public void insertType(BaseTradeTypeDO baseTradeTypeDO) {
        baseTradeTypeMapper.insertType(baseTradeTypeDO);
    }

    @Override
    public void deleteType(String id) {
        baseTradeTypeMapper.deleteType(id);
    }
}
