package com.dongni.dongnimall.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Component
public class LogisticsDO implements Serializable {
    //物流单号
    private String logistics_number;
    //所属订单号
    private String order_number;
    //配送方式
    private Integer delivery_method;

    public String getLogistics_number() {
        return logistics_number;
    }

    public void setLogistics_number(String logistics_number) {
        this.logistics_number = logistics_number;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public Integer getDelivery_method() {
        return delivery_method;
    }

    public void setDelivery_method(Integer delivery_method) {
        this.delivery_method = delivery_method;
    }
}
