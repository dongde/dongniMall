package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.OrderDO;
import com.dongni.dongnimall.vo.PageData;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
public interface OrderService {
    /**
     * @param orderDO
     * @Description: 添加订单
     */
    void addOrder(OrderDO orderDO);

    /**
     * @param order_number
     * @Description: 根据订单号删除订单
     */
    void removeOrder(String order_number);

    /**
     * @param page
     * @param pageSize
     * @return
     * @Description: 查询所有订单信息
     */
    PageData queryOrderList(Integer page, Integer pageSize);

    /**
     * @param orderDO
     * @Description: 修改订单信息
     */
    void modifyOrder(OrderDO orderDO);
}
