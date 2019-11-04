package com.dongni.dongnimall.vo;

import com.dongni.dongnimall.pojo.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Component
@Data
public class OrderVO implements Serializable {
    //订单编号
    private String order_number;
    //购买用户手机号
    private String user_phone;
    //支付金额
    private BigDecimal payment_amount;
    //支付方式
    private Integer payment_method;
    //订单状态
    private String status;
    //订单创建时间
    private String create_time;
    //订单完成时间
    private String complete_time;
    //收货人昵称
    private String rec_info_name;
}
