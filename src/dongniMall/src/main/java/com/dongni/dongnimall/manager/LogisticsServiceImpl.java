package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.LogisticsMapper;
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
public class LogisticsServiceImpl implements LogisticsService {
    @Autowired
    private LogisticsMapper logisticsMapper;

    @Override
    public void addLogistics(LogisticsDO logisticsDO) {
        logisticsMapper.insertLogistics(logisticsDO);
    }

    @Override
    public void removeLogistics(String order_number) {
        logisticsMapper.deleteLogistics(order_number);
    }

    @Override
    public LogisticsDO queryLogistics(String order_number) {
        return logisticsMapper.selectLogistics(order_number);
    }
}
