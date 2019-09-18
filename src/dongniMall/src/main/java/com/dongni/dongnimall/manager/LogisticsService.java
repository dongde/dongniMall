package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.LogisticsDO;
import com.dongni.dongnimall.vo.PageData;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
public interface LogisticsService {
    /**
     * @Description: 添加物流信息
     * @param logisticsDO
     */
    void addLogistics(LogisticsDO logisticsDO);

    /**
     * @Description: 删除物流信息
     * @param order_number
     */
    void removeLogistics(String order_number);

    /**
     * @Description: 查询物流信息
     * @param order_number
     * @return
     */
    LogisticsDO queryLogistics(String order_number);
}
