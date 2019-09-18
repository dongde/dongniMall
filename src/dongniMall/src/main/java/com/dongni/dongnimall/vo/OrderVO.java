package com.dongni.dongnimall.vo;

import com.dongni.dongnimall.pojo.GoodsDO;
import com.dongni.dongnimall.pojo.LogisticsDO;
import com.dongni.dongnimall.pojo.OrderDO;
import com.dongni.dongnimall.pojo.UserDO;

import java.io.Serializable;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
public class OrderVO implements Serializable {
    //订单
    private OrderDO orderDO;
    //物流
    private LogisticsDO logisticsDO;
    //商品
    private GoodsDO goodsDO;
    //用户
    private UserDO userDO;

    public OrderDO getOrderDO() {
        return orderDO;
    }

    public void setOrderDO(OrderDO orderDO) {
        this.orderDO = orderDO;
    }

    public LogisticsDO getLogisticsDO() {
        return logisticsDO;
    }

    public void setLogisticsDO(LogisticsDO logisticsDO) {
        this.logisticsDO = logisticsDO;
    }

    public GoodsDO getGoodsDO() {
        return goodsDO;
    }

    public void setGoodsDO(GoodsDO goodsDO) {
        this.goodsDO = goodsDO;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }
}
