package com.dongni.dongnimall.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Component
public class GoodsDO implements Serializable {
    //所属订单号
    private String order_number;
    //商品名称
    private String goods_name;
    //商品图片
    private String goods_img;
    //商品数量
    private Integer goods_count;
    //商品小计
    private BigDecimal subtotal;

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public Integer getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(Integer goods_count) {
        this.goods_count = goods_count;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
